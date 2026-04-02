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
 * @version 1.1
 */
public class Utilizador extends Pessoa {

    private String username;
    private String password;
    private boolean isAdmin;
    private Perfil perfil;

    /**
     * Construtor vazio. Cria um utilizador sem dados definidos.
     */
    public Utilizador() {
    }

    /**
     * Construtor completo. Cria um utilizador com todos os dados validados.
     *
     * @param id Identificador único do utilizador.
     * @param nome Nome completo do utilizador.
     * @param username Nome de login.
     * @param password Senha de acesso.
     * @param isAdmin Indica se o utilizador é administrador.
     * @param perfil Perfil associado ao utilizador.
     * @throws DadosInvalidosException Se algum dado for inválido.
     */
    public Utilizador(int id, String nome, String username, String password,
            boolean isAdmin, Perfil perfil) throws DadosInvalidosException {
        
        super(id, nome);
        setUsername(username);
        setPassword(password);
        setPerfil(perfil);
        
        this.isAdmin = isAdmin;
    }

    /**
     * Construtor simplificado para autenticação.
     *
     * @param id Identificador único do utilizador.
     * @param username Nome de login.
     * @param password Senha de acesso.
     * @param isAdmin Indica se o utilizador é administrador.
     * @param perfil Perfil associado ao utilizador.
     * @throws DadosInvalidosException Se algum dado for inválido.
     */
    public Utilizador(int id, String username, String password,
            boolean isAdmin, Perfil perfil) throws DadosInvalidosException {
        
        super(id, username);
        setUsername(username);
        setPassword(password);
        setPerfil(perfil);
        
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
     *
     * @param username Nome de login.
     * @throws DadosInvalidosException Se o username for nulo ou vazio.
     */
    private void setUsername(String username) throws DadosInvalidosException {
        if (username == null || username.isBlank()) {
            throw new DadosInvalidosException("Username inválido.");
        }
        this.username = username;
    }

    /**
     * Retorna a password do utilizador.
     *
     * @return Password do utilizador.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a password do utilizador.
     *
     * @param password Senha de acesso.
     * @throws DadosInvalidosException Se a password for nula ou tiver menos de 3 caracteres.
     */
    private void setPassword(String password) throws DadosInvalidosException {
        if (password == null || password.length() < 3) {
            throw new DadosInvalidosException("Password inválida.");
        }
        this.password = password;
    }

    /**
     * Verifica se o utilizador é administrador.
     *
     * @return {@code true} se for administrador, {@code false} caso contrário.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Define se o utilizador é administrador.
     *
     * @param isAdmin {@code true} para administrador, {@code false} caso contrário.
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Retorna o perfil do utilizador.
     *
     * @return Perfil associado ao utilizador.
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Define o perfil do utilizador.
     *
     * @param perfil Perfil associado ao utilizador.
     * @throws DadosInvalidosException Se o perfil for nulo.
     */
    public void setPerfil(Perfil perfil) throws DadosInvalidosException {
        if (perfil == null) {
            throw new DadosInvalidosException("Perfil inválido.");
        }
        this.perfil = perfil;
    }

    /**
     * Retorna uma representação textual do utilizador.
     *
     * @return Texto com os dados principais do utilizador.
     */
    @Override
    public String toString() {
        return "Utilizador{"
                + "id=" + getId()
                + ", nome='" + getNome() + '\''
                + ", username='" + username + '\''
                + ", isAdmin=" + isAdmin
                + ", perfil=" + (perfil != null ? perfil.getNomePerfil() : "sem perfil")
                + '}';
    }
}