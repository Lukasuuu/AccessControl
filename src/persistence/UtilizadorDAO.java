package persistence;

import model.Utilizador;
import model.Perfil;
import exception.DadosInvalidosException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


/**
 * Classe de acesso à base de dados para a entidade {@link Utilizador}.
 * 
 * Responsável por todas as operações SQL relacionadas com utilizadores,
 * nomeadamente a autenticação por username e password.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */
public class UtilizadorDAO {

    /**
     * Construtor vazio padrão.
     */
    public UtilizadorDAO() {
    }

    /**
     * Autentica um utilizador com base nas credenciais fornecidas.
     * 
     * Consulta a base de dados pelo username e password. 
     * Se as credenciais forem válidas, retorna o {@link Utilizador} correspondente. 
     * Caso contrário, retorna {@code null}.
     *
     * @param username Nome de login do utilizador. 
     * Não pode ser nulo nem vazio.
     * @param password Senha de acesso do utilizador. 
     * Não pode ser nula nem
     * vazia.
     * @return Objeto {@link Utilizador} autenticado, ou {@code null} se as
     * credenciais forem inválidas.
     * @throws DadosInvalidosException se os campos estiverem vazios ou ocorrer
     * erro na base de dados.
     */
    public Utilizador fazerLogin(String username, String password) throws DadosInvalidosException {

        String sql = "SELECT u.id, u.username, u.password, u.is_admin, "
                + "p.id AS perfil_id, p.nome_perfil "
                + "FROM utilizador u "
                + "INNER JOIN perfil p ON u.perfil_id = p.id "
                + "WHERE u.username = ? AND u.password = ?";

        try ( Connection con = Conexao.getConexao();  
              PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try ( ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Perfil perfil = new Perfil(
                            rs.getInt("perfil_id"),
                            rs.getString("nome_perfil")
                    );
                    return new Utilizador(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getBoolean("is_admin"),
                            perfil
                    );
                } else {
                    System.out.println("Utilizador ou password incorretos.");
                }
            }
        } catch (SQLException e) {
            throw new DadosInvalidosException("Erro ao aceder à base de dados: " + e.getMessage());
        }
        return null;
    }

    // =========================================================
    // REGISTAR NOVO UTILIZADOR
    // =========================================================

    /**
     * Regista um novo utilizador na base de dados.
     * Insere primeiro na tabela pessoa, depois em utilizador.
     *
     * @param nome     Nome completo.
     * @param username Username de login.
     * @param password Password.
     * @param isAdmin  true se Administrador.
     * @param perfilId ID do perfil (1=Admin, 2=Utilizador).
     * @throws DadosInvalidosException se ocorrer erro na BD.
     */
    public void registarUtilizador(String nome, String username, String password,
                                    boolean isAdmin, int perfilId)
            throws DadosInvalidosException {

        // Verificar se username já existe
        if (usernameExiste(username)) {
            throw new DadosInvalidosException("O username \"" + username + "\" já está em uso.");
        }

        Connection con = null;
        try {
            con = Conexao.getConexao();
            con.setAutoCommit(false); // transação

            //Inserir pessoa
            int pessoaId;
            String sqlPessoa = "INSERT INTO pessoa (nome) VALUES (?)";
            
            // Dizemos ao JDBC: "após o INSERT, guarda os IDs gerados
            try (PreparedStatement ps = con.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nome);
                ps.executeUpdate();// executa o INSERT
                
                // Agora pedimos esses IDs de volta
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new DadosInvalidosException("Erro ao criar pessoa.");
                    pessoaId = rs.getInt(1); // rs.getInt(1) = primeiro (e único) ID gerado
                }
            }

            //Inserir utilizador
            String sqlUtil = "INSERT INTO utilizador (username, password, is_admin, pessoa_id, perfil_id) "
                           + "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sqlUtil)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setBoolean(3, isAdmin);
                ps.setInt(4, pessoaId);
                ps.setInt(5, perfilId);
                ps.executeUpdate();
            }

            con.commit();

        } catch (SQLException e) {
            if (con != null) {
                try { con.rollback(); } catch (SQLException ignored) {}
            }
            throw new DadosInvalidosException("Erro ao registar utilizador: " + e.getMessage());
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); con.close(); } catch (SQLException ignored) {}
            }
        }
    }

    /**
     * Verifica se um username já existe na base de dados.
     */
    private boolean usernameExiste(String username) throws DadosInvalidosException {
        String sql = "SELECT COUNT(*) FROM utilizador WHERE username = ?";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new DadosInvalidosException("Erro ao verificar username: " + e.getMessage());
        }
    }

    // =========================================================
    // LISTAR TODOS OS UTILIZADORES
    // =========================================================

    /**
     * Retorna todos os utilizadores registados, incluindo o perfil associado.
     *
     * @return Lista de Utilizador.
     * @throws DadosInvalidosException se ocorrer erro na BD.
     */
    public List<Utilizador> listarUtilizadores() throws DadosInvalidosException {
        List<Utilizador> lista = new ArrayList<>();
        String sql = "SELECT u.id, u.username, u.password, u.is_admin, "
                   + "p.id AS perfil_id, p.nome_perfil "
                   + "FROM utilizador u "
                   + "INNER JOIN perfil p ON u.perfil_id = p.id "
                   + "ORDER BY u.id";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Perfil perfil = new Perfil(rs.getInt("perfil_id"), rs.getString("nome_perfil"));
                Utilizador u = new Utilizador(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("is_admin"),
                    perfil
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            throw new DadosInvalidosException("Erro ao listar utilizadores: " + e.getMessage());
        }
        return lista;
    }

    // =========================================================
    // ATRIBUIR PERMISSÃO (alterar perfil + is_admin)
    // =========================================================

    /**
     * Atualiza o perfil e o flag is_admin de um utilizador.
     *
     * @param utilizadorId ID do utilizador a alterar.
     * @param perfilId     Novo perfil (1=Admin, 2=Utilizador).
     * @param isAdmin      Novo valor de is_admin.
     * @throws DadosInvalidosException se ocorrer erro na BD.
     */
    public void atualizarPermissao(int utilizadorId, int perfilId, boolean isAdmin)
            throws DadosInvalidosException {
        String sql = "UPDATE utilizador SET perfil_id = ?, is_admin = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, perfilId);
            ps.setBoolean(2, isAdmin);
            ps.setInt(3, utilizadorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DadosInvalidosException("Erro ao atualizar permissão: " + e.getMessage());
        }
    }
}
