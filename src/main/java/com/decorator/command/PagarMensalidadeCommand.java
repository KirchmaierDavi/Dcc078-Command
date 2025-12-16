package com.decorator.command;

public class PagarMensalidadeCommand implements Command {
    private Sindicato sindicato;
    private String membro;
    private double valor;

    public PagarMensalidadeCommand(Sindicato sindicato, String membro, double valor) {
        this.sindicato = sindicato;
        this.membro = membro;
        this.valor = valor;
    }

    @Override
    public void execute() {
        sindicato.pagarMensalidade(membro, valor);
    }
}

