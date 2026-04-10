package exception;

/**
 * Exceção personalizada para validação de dados inválidos ou em falta.
 * 
 * Lançada quando os dados fornecidos pelo utilizador não cumprem
 * os requisitos de validação da aplicação, como campos vazios,
 * nulos ou com formato incorreto.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 * @version 1.0
 */
public class DadosInvalidosException extends Exception {

    /**
     * Construtor padrão sem mensagem de erro.
     */
    public DadosInvalidosException() {
        super();
    }

    /**
     * Construtor com mensagem de erro personalizada.
     *
     * @param message Mensagem descritiva do erro de validação.
     */
    public DadosInvalidosException(String message) {
        super(message);
    }
}