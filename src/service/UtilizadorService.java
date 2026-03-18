package service;

import exception.DadosInvalidosException;
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

    private final UtilizadorDAO utilizadorDAO;

    /**
     * Construtor padrão.
     * Inicializa a camada de persistência do utilizador.
     */
    public UtilizadorService() {
        this.utilizadorDAO = new UtilizadorDAO();
    }

    /**
     * Autentica um utilizador no sistema.
     *
     * Regras:
     * - Se username estiver vazio, lança exceção.
     * - Se password estiver vazia, lança exceção.
     * - Se as credenciais estiverem erradas, retorna null.
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
}