package model;

import exception.DadosInvalidosException;

/**
 * Representa um utilizador autenticável no sistema AccessControl.
 * <p>
 * Estende {@link Pessoa} com credenciais de acesso e nível de permissão,
 * suportando autenticação básica por username e password.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */
public class Utilizador extends Pessoa {

    private String username;
    private String password;
    private boolean isAdmin;

    /**
     * Construtor vazio. Cria um utilizador sem dados definidos.
     */
    public Utilizador() {
    }

    /**
     * Construtor completo. Cria um utilizador com todos os dados validados.
     *
     * @param id       Identificador único do utilizador. Deve ser maior que zero.
     * @param nome     Nome completo do utilizador. Não pode ser nulo nem vazio.
     * @param username Nome de login. Não pode ser nulo nem vazio.
     * @param password Senha de acesso. Deve ter no mínimo 3 caracteres.
     * @param isAdmin  {@code true} se o utilizador for administrador, {@code false} caso contrário.
     * @throws DadosInvalidosException se algum dos dados fornecidos for inválido.
     */
    public Utilizador(int id, String nome, String username, String password, boolean isAdmin)
            throws DadosInvalidosException {
        super(id, nome);
        setUsername(username);
        setPassword(password);
        this.isAdmin = isAdmin;
    }

    /**
     * Construtor simplificado para autenticação.
     * <p>
     * Utilizado quando o nome completo não é necessário,
     * por exemplo, ao carregar dados de login da base de dados.
     *
     * @param id       Identificador único do utilizador. Deve ser maior que zero.
     * @param username Nome de login. Não pode ser nulo nem vazio.
     * @param password Senha de acesso. Deve ter no mínimo 3 caracteres.
     * @param isAdmin  {@code true} se o utilizador for administrador, {@code false} caso contrário.
     * @throws DadosInvalidosException se algum dos dados fornecidos for inválido.
     */
    public Utilizador(int id, String username, String password, boolean isAdmin)
            throws DadosInvalidosException {
        super(id, username);
        setUsername(username);
        setPassword(password);
        this.isAdmin = isAdmin;
    }

    /**
     * Retorna o nome de login do utilizador.
     *
     * @return Username do utilizador.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o nome de login do utilizador.
     * <p>
     * Método privado — o username só pode ser atribuído pelo construtor.
     *
     * @param username Nome de login. Não pode ser nulo nem vazio.
     * @throws DadosInvalidosException se o username for nulo ou em branco.
     */
    private void setUsername(String username) throws DadosInvalidosException {
        if (username == null || username.isBlank()) {
            throw new DadosInvalidosException("Username inválido.");
        }
        this.username = username;
    }

    /**
     * Retorna a senha de acesso do utilizador.
     *
     * @return Password do utilizador.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha de acesso do utilizador.
     * <p>
     * Método privado — a password só pode ser atribuída pelo construtor.
     *
     * @param password Senha de acesso. Deve ter no mínimo 3 caracteres.
     * @throws DadosInvalidosException se a password for nula ou tiver menos de 3 caracteres.
     */
    private void setPassword(String password) throws DadosInvalidosException {
        if (password == null || password.length() < 3) {
            throw new DadosInvalidosException("Password inválida.");
        }
        this.password = password;
    }

    /**
     * Indica se o utilizador tem permissões de administrador.
     *
     * @return {@code true} se for administrador, {@code false} caso contrário.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Define o nível de permissão do utilizador.
     *
     * @param isAdmin {@code true} para conceder permissões de administrador,
     *                {@code false} para revogar.
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}