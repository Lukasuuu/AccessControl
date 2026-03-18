package model;

import exception.DadosInvalidosException;

/**
 * Representa o tipo de acesso de um utilizador no sistema AccessControl.
 * <p>
 * Cada perfil define um nível de permissão, como Administrador ou Utilizador,
 * sendo utilizado para controlar o acesso às funcionalidades da aplicação.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */
public class Perfil {

    private int id;
    private String nomePerfil;

    /**
     * Construtor vazio. Cria um perfil sem dados definidos.
     */
    public Perfil() {
    }

    /**
     * Construtor completo. Cria um perfil com todos os dados validados.
     *
     * @param id         Identificador único do perfil. Deve ser maior que zero.
     * @param nomePerfil Nome descritivo do perfil (ex: "Administrador", "Utilizador").
     * @throws DadosInvalidosException se o ID for inválido ou o nome for nulo/vazio.
     */
    public Perfil(int id, String nomePerfil) throws DadosInvalidosException {
        setId(id);
        setNomePerfil(nomePerfil);
    }

    /**
     * Retorna o identificador único do perfil.
     *
     * @return ID do perfil.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do perfil.
     *
     * @param id ID do perfil. Deve ser maior que zero.
     * @throws DadosInvalidosException se o ID for menor ou igual a zero.
     */
    public void setId(int id) throws DadosInvalidosException {
        if (id <= 0) {
            throw new DadosInvalidosException("ID do perfil inválido.");
        }
        this.id = id;
    }

    /**
     * Retorna o nome descritivo do perfil.
     *
     * @return Nome do perfil.
     */
    public String getNomePerfil() {
        return nomePerfil;
    }

    /**
     * Define o nome descritivo do perfil.
     *
     * @param nomePerfil Nome do perfil. Não pode ser nulo nem vazio.
     * @throws DadosInvalidosException se o nome for nulo ou em branco.
     */
    public void setNomePerfil(String nomePerfil) throws DadosInvalidosException {
        if (nomePerfil == null || nomePerfil.isBlank()) {
            throw new DadosInvalidosException("Nome do perfil inválido.");
        }
        this.nomePerfil = nomePerfil;
    }
}