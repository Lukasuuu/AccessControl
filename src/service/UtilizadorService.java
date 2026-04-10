package service;

import exception.DadosInvalidosException;
import java.util.List;
import model.Utilizador;
import persistence.UtilizadorDAO;

/**
 * Classe UtilizadorService - Camada de serviço para regras de negócio do utilizador.
 * Versão para autenticação e validação no sistema.
 * 
 * Responsabilidades:
 * validar os dados recebidos da interface;
 * chamar a camada de persistência da base de dados;
 * devolver o utilizador autenticado ou null em caso de credenciais inválidas.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 */
public class UtilizadorService {

    private UtilizadorDAO utilizadorDAO;

    /**
     * Construtor padrão.
     * Inicializa a camada de persistência do utilizador.
     */
    public UtilizadorService() {
        this.utilizadorDAO = new UtilizadorDAO();
    }

    // =========================================================
    // AUTENTICAR UTILIZADOR
    // =========================================================
    /**
     * Autentica um utilizador no sistema.
     *
     * Regras:
     * Se username estiver vazio, lança exceção.
     * Se password estiver vazia, lança exceção.
     * Se as credenciais estiverem erradas, retorna null.
     *
     * @param username Nome de utilizador (login).
     * @param password Senha do utilizador.
     * @return Utilizador autenticado ou null se as credenciais forem inválidas.
     * @throws DadosInvalidosException Se os campos obrigatórios não forem preenchidos.
     */
    public Utilizador autenticar(String username, String password) throws DadosInvalidosException {

        if (username == null || username.isBlank()) {
            throw new DadosInvalidosException("Informe o utilizador.");
        }

        if (password == null || password.isBlank()) {
            throw new DadosInvalidosException("Informe a senha.");
        }

        return utilizadorDAO.fazerLogin(username.trim(), password.trim());
    }
    // =========================================================
    // REGISTAR UTILIZADOR
    // =========================================================

    /**
     * Valida e regista um novo utilizador.
     *
     * @param nome     Nome completo (obrigatório).
     * @param username Username único (obrigatório).
     * @param password Password com mínimo 3 caracteres.
     * @param isAdmin  true para Administrador.
     * @param perfilId ID do perfil (1=Admin, 2=Utilizador).
     */
    public void registarUtilizador(String nome, String username, String password,
                                    boolean isAdmin, int perfilId)
            throws DadosInvalidosException {

        if (nome == null || nome.isBlank())
            throw new DadosInvalidosException("O nome é obrigatório.");
        if (username == null || username.isBlank())
            throw new DadosInvalidosException("O username é obrigatório.");
        if (password == null || password.length() < 3)
            throw new DadosInvalidosException("A password deve ter pelo menos 3 caracteres.");
        if (perfilId <= 0)
            throw new DadosInvalidosException("Selecione um perfil válido.");

        utilizadorDAO.registarUtilizador(
            nome.trim(), username.trim(), password, isAdmin, perfilId
        );
    }

    // =========================================================
    // LISTAR UTILIZADORES
    // =========================================================
    /**
     * Lista todos os utilizadores registados no sistema.
     *
     * @return Lista de objetos {@link Utilizador} contendo todos os utilizadores.
     * @throws DadosInvalidosException Caso ocorra algum erro ao obter os utilizadores.
     */
    public List<Utilizador> listarUtilizadores() throws DadosInvalidosException {
        return utilizadorDAO.listarUtilizadores();
    }

    // =========================================================
    // ATRIBUIR PERMISSÃO (indicado na Listagem)
    // =========================================================
    /**
     * Atualiza as permissões de um utilizador específico.
     *
     * @param utilizadorId ID do utilizador a ser atualizado.
     * @param perfilId ID do perfil a ser atribuído ao utilizador.
     * @param isAdmin Indica se o utilizador terá privilégios de administrador(true) ou não (false).
     * @throws DadosInvalidosException 
     * Se o utilizadorId ou perfilId forem inválidos (menores ou iguais a zero), ou se ocorrer algum erro na atualização das permissões.
     */
    public void atualizarPermissao(int utilizadorId, int perfilId, boolean isAdmin)
            throws DadosInvalidosException {
        if (utilizadorId <= 0)
            throw new DadosInvalidosException("Utilizador inválido.");
        if (perfilId <= 0)
            throw new DadosInvalidosException("Perfil inválido.");
        utilizadorDAO.atualizarPermissao(utilizadorId, perfilId, isAdmin);
    }
}