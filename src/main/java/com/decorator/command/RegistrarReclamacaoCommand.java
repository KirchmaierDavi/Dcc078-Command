package com.decorator.command;

public class RegistrarReclamacaoCommand implements Command {
    private Sindicato sindicato;
    private String membro;
    private String reclamacao;

    public RegistrarReclamacaoCommand(Sindicato sindicato, String membro, String reclamacao) {
        this.sindicato = sindicato;
        this.membro = membro;
        this.reclamacao = reclamacao;
    }

    @Override
    public void execute() {
        sindicato.registrarReclamacao(membro, reclamacao);
    }
}

