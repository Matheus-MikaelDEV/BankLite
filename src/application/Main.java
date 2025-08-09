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
            System.out.println("Sacar(sim, não ou mostrar saques)? ");
            opcao = sc.nextLine();

            switch (opcao){
                case "sim":
                    sistema.saque();
                    break;
                case "não":
                    System.out.println(sistema.getConta());
                    break;
                case "mostrar saques":
                    sistema.mostrarSaques();
                    break;
                default:
                        System.out.println("Opção inválida!");
                        break;
            }
        } while (opcao.equalsIgnoreCase("sim") || !opcao.equalsIgnoreCase("não"));
    }
}
