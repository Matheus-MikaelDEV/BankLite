package maneger;

import model.account.Conta;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {
    Scanner sc = new Scanner(System.in);

    Conta conta = new Conta();

    public void cadastroConta() {
        boolean concluido = false;

        do {
            try {
                System.out.println("ID da conta: ");
                Integer ID = sc.nextInt();
                sc.nextLine();

                System.out.println("Nome do titular da conta: ");
                String nomeDoTitularDaConta = sc.nextLine();

                System.out.println("Balanço: ");
                BigDecimal balanco = sc.nextBigDecimal();
                sc.nextLine();

                System.out.println("Limite de saque: ");
                BigDecimal limiteDeSaque = sc.nextBigDecimal();
                sc.nextLine();

                concluido = true;

                conta = new Conta(ID, nomeDoTitularDaConta, balanco, limiteDeSaque);
            } catch (InputMismatchException e) {
                System.out.println("Falha... Tente novamente: ");
                sc.nextLine();
            }
        } while (!concluido);
    }

    public void saque() {
        try {
            System.out.println("Quantos você quer sacar? ");
            BigDecimal saque = sc.nextBigDecimal();
            sc.nextLine();

            if (saque.compareTo(BigDecimal.ZERO) <= 0 || saque.compareTo(conta.getLimiteDeSaque()) > 0 || saque.compareTo(conta.getBalanco()) > 0) {
                System.out.println("Valor inválido!");


            } else {
                conta.removeBalanco(saque);
                System.out.println("Saque realizado com sucesso!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Falha...");
            sc.nextLine();
        }
    }

    public Conta getConta() {
        return conta;
    }
}
