package persistence;

import model.Utilizador;
import exception.DadosInvalidosException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Perfil;

/**
 * Classe de acesso à base de dados para a entidade {@link Utilizador}.
 * <p>
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
     * <p>
     * Consulta a base de dados pelo username e password. Se as credenciais
     * forem válidas, retorna o {@link Utilizador} correspondente. Caso
     * contrário, retorna {@code null}.
     *
     * @param username Nome de login do utilizador. Não pode ser nulo nem vazio.
     * @param password Senha de acesso do utilizador. Não pode ser nula nem
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

        try ( Connection con = Conexao.getConexao();  PreparedStatement ps = con.prepareStatement(sql)) {
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
}
