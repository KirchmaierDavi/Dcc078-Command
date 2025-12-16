package com.decorator.command;

import java.util.ArrayList;
import java.util.List;

public class AdministradorSindicato {
    private List<Command> historicoComandos = new ArrayList<>();

    public void executarComando(Command command) {
        command.execute();
        historicoComandos.add(command);
    }

    public List<Command> getHistoricoComandos() {
        return historicoComandos;
    }
}

