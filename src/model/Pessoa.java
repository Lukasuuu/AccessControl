package model;

import exception.DadosInvalidosException;

/**
 * Representa uma pessoa no sistema AccessControl.
 * 
 * Classe base que encapsula os dados essenciais de uma pessoa, servindo de base
 * para outras entidades como {@link Utilizador}.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */
public class Pessoa {

    private int id;
    private String nome;

    /**
     * Construtor vazio. Cria uma pessoa sem dados definidos.
     */
    public Pessoa() {
    }

    /**
     * Construtor completo. Cria uma pessoa com todos os dados validados.
     *
     * @param id Identificador único da pessoa. Deve ser maior que zero.
     * @param nome Nome da pessoa. Não pode ser nulo nem vazio.
     * @throws DadosInvalidosException se o ID for inválido ou o nome for
     * nulo/vazio.
     */
    public Pessoa(int id, String nome) throws DadosInvalidosException {
        setId(id);
        setNome(nome);
    }

    /**
     * Retorna o identificador único da pessoa.
     *
     * @return ID da pessoa.
     */
    public int getId() {
        return id;
    }


    /**
     * Define o identificador único da pessoa.
     * 
     * Método privado — o ID só pode ser atribuído pelo construtor.
     *
     * @param id ID da pessoa. Deve ser maior que zero.
     * @throws DadosInvalidosException se o ID for menor ou igual a zero.
     */
    public void setId(int id) throws DadosInvalidosException {
        if (id <= 0) {
            throw new DadosInvalidosException("ID inválido.");
        }
        this.id = id;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Construtor simplificado. Cria uma pessoa apenas com o nome.
     *
     * Utilizado quando o identificador ainda não está definido, por exemplo,
     * antes de persistir a pessoa na base de dados.
     *
     * @param nome Nome da pessoa. Não pode ser nulo nem vazio.
     * @throws DadosInvalidosException se o nome for nulo ou em branco.
     */
    public Pessoa(String nome) throws DadosInvalidosException {
        setNome(nome);
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome Nome da pessoa. Não pode ser nulo nem vazio.
     * @throws DadosInvalidosException se o nome for nulo ou em branco.
     */
    public void setNome(String nome) throws DadosInvalidosException {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosException("Nome inválido.");
        }
        this.nome = nome;
    }

   

    /**
     * Retorna uma representação textual de pessoa
     * 
     * @return Texto com os dados principais de pessoa.
     */
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }

}
