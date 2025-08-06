package model.account;

import java.math.BigDecimal;

public class Conta {
    private Integer ID;
    private String nomeDoTitularDaConta;
    private BigDecimal balanco;
    private BigDecimal limiteDeSaque;

    public Conta() {
    }

    public Conta(Integer ID, String nomeDoTitularDaConta, BigDecimal balanco, BigDecimal limiteDeSaque) {
        this.ID = ID;
        this.nomeDoTitularDaConta = nomeDoTitularDaConta;
        this.balanco = balanco;
        this.limiteDeSaque = limiteDeSaque;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(ID).append("\n");
        sb.append("Nome do Titular da Conta: ").append(nomeDoTitularDaConta).append("\n");
        sb.append("Balanço: ").append(balanco).append("\n");
        sb.append("Limite de Saque: ").append(limiteDeSaque).append("\n");
        return sb.toString();
    }

    public Integer getID() {
        return ID;
    }

    public String getNomeDoTitularDaConta() {
        return nomeDoTitularDaConta;
    }

    public BigDecimal getBalanco() {
        return balanco;
    }

    public BigDecimal getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void removeBalanco(BigDecimal saque) {
        balanco.subtract(saque);
    }
}
