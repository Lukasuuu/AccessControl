package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exception.DadosInvalidosException;

/**
 * Classe responsável por estabelecer ligação com a base de dados MySQL. 
 * Fornece métodos utilitários para obter e testar conexões.
 *
 * Como funciona:
 *  Armazena os dados do servidor, base de dados, utilizador e senha.
 *  O método {@link #getConexao()} retorna uma {@link Connection} ativa.
 *
 * Configuração:
 *  Host: 62.28.39.135
 *  Porta: 3306
 *  Base de dados: efa0125_08_projeto_java
 *  Utilizador: efa0125_08
 *
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */

public class Conexao {

    // ===== DADOS DA BASE DE DADOS =====
    private static final String SERVIDOR = "62.28.39.135";
    private static final String BASE_DADOS = "efa0125_08_projeto_java";
    private static final String UTILIZADOR = "efa0125";
    private static final String SENHA = "123.Abc";

    /**
     * URL de conexão JDBC construída a partir do servidor e base de dados.
     */
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASE_DADOS;

    /**
     * Construtor privado — impede a instanciação desta classe utilitária. 
     * 
     * Todos os métodos são estáticos e devem ser acedidos diretamente pela classe.
     */
    private Conexao() {
        throw new UnsupportedOperationException("Classe utilitária — não pode ser instanciada.");
    }

    /**
     * Estabelece e retorna uma conexão ativa com a base de dados MySQL.
     *
     * @return Objeto {@link Connection} ativo.
     * @throws DadosInvalidosException se ocorrer erro ao conectar à base de
     * dados.
     */
    public static Connection getConexao() throws DadosInvalidosException {
        try {
            Connection conexao = DriverManager.getConnection(URL, UTILIZADOR, SENHA);
            System.out.println("Ligado ao MySQL com sucesso!");
            return conexao;
        } catch (SQLException e) {
            throw new DadosInvalidosException("Erro ao conectar ao MySQL: " + e.getMessage());
        }
    }

    /**
     * Método utilitário para testar a conexão com a base de dados. 
     * 
     * Exibe mensagens no console com o resultado do teste. 
     * Todos os erros são tratados internamente — nunca propaga exceções.
     */
    public static void testarConexao() {
        System.out.println("========================================");
        System.out.println("  TESTE DE CONEXAO AO MYSQL");
        System.out.println("========================================");
        System.out.println("Servidor: " + SERVIDOR);
        System.out.println("Base de Dados: " + BASE_DADOS);
        System.out.println("Utilizador: " + UTILIZADOR);
        System.out.println("========================================");
        try ( Connection conexao = getConexao()) {
            if (conexao != null) {
                System.out.println("SUCESSO! A conexao esta a funcionar!");
            }
        } catch (DadosInvalidosException e) {
            System.out.println("ERRO ao conectar:");
            System.out.println("Detalhes: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("ERRO ao fechar a conexão:");
            System.out.println("Detalhes: " + e.getMessage());
        }
        System.out.println("========================================");
    }

    /**
     * Método principal para executar o teste de conexão diretamente.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        testarConexao();
    }
}
