package application;

import maneger.Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Sistema sistema = new Sistema();

        String opcao = " ";

        sistema.cadastroConta();

        do {
            System.out.println("Sacar(sim ou não)? ");
            opcao = sc.nextLine();

            switch (opcao){
                case "sim":
                    sistema.saque();
                    break;
                case "não":
                    System.out.println(sistema.getConta());
                    break;
                default:
                        System.out.println("Opção inválida!");
            }
        } while (opcao.equalsIgnoreCase("sim"));
    }
}
