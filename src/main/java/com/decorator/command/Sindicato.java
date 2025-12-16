package com.decorator.command;

import java.util.ArrayList;
import java.util.List;

public class Sindicato {
    private String nome;
    private List<String> reclamacoes = new ArrayList<>();
    private double caixa = 0;

    public Sindicato(String nome) {
        this.nome = nome;
    }

    public void pagarMensalidade(String membro, double valor) {
        this.caixa += valor;
        System.out.println("Mensalidade de " + valor + " paga pelo membro " + membro + ".");
    }

    public void registrarReclamacao(String membro, String reclamacao) {
        this.reclamacoes.add(membro + ": " + reclamacao);
        System.out.println("Reclamação registrada de " + membro + ": " + reclamacao);
    }

    public double getCaixa() {
        return caixa;
    }

    public List<String> getReclamacoes() {
        return reclamacoes;
    }
}

