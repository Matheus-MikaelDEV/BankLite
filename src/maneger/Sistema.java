package maneger;

import model.account.Conta;

import java.io.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {
    Scanner sc = new Scanner(System.in);

    Conta conta = new Conta();

    public void cadastroConta() {
        boolean concluido = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader("contaUsuario.txt"))) {
            String linha;

            if ((linha = br.readLine()) != null) {
                String[] vetor = linha.split(", ");

                Integer id = Integer.parseInt(vetor[0].replace("ID: ", ""));
                String nome = vetor[1].replace("Nome do titular da conta: ", "");
                BigDecimal balanco = new BigDecimal(vetor[2].replace("Balanço: ", ""));
                BigDecimal limite = new BigDecimal(vetor[3].replace("Limite de saque: ", ""));
                conta = new Conta(id, nome, balanco, limite);
                concluido = true;
                return;
            }
        } catch (IOException e) {
        }

        while (!concluido) {
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

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("contaUsuario.txt"))) {
                    bw.write("ID: " + ID +", Nome do titular da conta: " + nomeDoTitularDaConta + ", Balanço: " + balanco + ", Limite de saque: " + limiteDeSaque);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (InputMismatchException e) {
                System.out.println("Falha... Tente novamente: ");
                sc.nextLine();
            }
        }
    }

    public void saque() {
        try {
            System.out.println("Quantos você quer sacar? ");
            BigDecimal saque = sc.nextBigDecimal();

            if (saque.compareTo(BigDecimal.ZERO) <= 0 || saque.compareTo(conta.getLimiteDeSaque()) > 0 || saque.compareTo(conta.getBalanco()) > 0) {
                System.out.println("Valor inválido!");
            } else {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("saques.txt", true))) {
                    bw.newLine();
                    bw.write("Balanço inicial: " + conta.getBalanco() + " Saque: " + saque + " Saldo final: " + (conta.getBalanco().subtract(saque)));
                    conta.removeBalanco(saque);

                    try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("contaUsuario.txt"))) {
                        bw2.write("ID: " + conta.getID() +", Nome do titular da conta: " + conta.getNomeDoTitularDaConta() + ", Balanço: " + conta.getBalanco() + ", Limite de saque: " + conta.getLimiteDeSaque());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Saque realizado com sucesso!");
            }
        } catch(InputMismatchException e){
            System.out.println("Falha...");
        } finally {
            sc.nextLine();
        }
    }

    public void mostrarSaques() {
        try (BufferedReader br = new BufferedReader(new FileReader("saques.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public Conta getConta() {
        return conta;
    }
}
