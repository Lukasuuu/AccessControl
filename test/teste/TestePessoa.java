package teste;

import exception.DadosInvalidosException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Pessoa;

/**
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 */
public class TestePessoa {

    public static void main(String[] args) throws DadosInvalidosException {

        Scanner sc = new Scanner(System.in);
        Pessoa p = new Pessoa();
        try {
            System.out.println("Insira um nome: ");
            String nome = sc.next();
            p.setNome(nome);

            System.out.println("Introduza uma idade: ");
            int idade;
            try {
                idade = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new DadosInvalidosException("A idade tem de ser um numero inteiro.");
            }

            System.out.println(p.getNome());

        } catch (DadosInvalidosException e) {
            System.out.println("Erro! Dados invalidos: " + e.getMessage());
        }
    }
}
