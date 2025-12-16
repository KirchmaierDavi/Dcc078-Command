package com.decorator.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SindicatoCommandTest {

    @Test
    void testPagarMensalidadeCommand() {
        Sindicato sindicato = new Sindicato("Sindicato dos Metalúrgicos");
        AdministradorSindicato admin = new AdministradorSindicato();

        Command pagarMensalidade = new PagarMensalidadeCommand(sindicato, "João", 100.0);
        admin.executarComando(pagarMensalidade);

        assertEquals(100.0, sindicato.getCaixa());
        assertEquals(1, admin.getHistoricoComandos().size());
    }

    @Test
    void testRegistrarReclamacaoCommand() {
        Sindicato sindicato = new Sindicato("Sindicato dos Professores");
        AdministradorSindicato admin = new AdministradorSindicato();

        Command registrarReclamacao = new RegistrarReclamacaoCommand(sindicato, "Maria", "Aumento salarial");
        admin.executarComando(registrarReclamacao);

        assertEquals(1, sindicato.getReclamacoes().size());
        assertTrue(sindicato.getReclamacoes().get(0).contains("Maria"));
        assertTrue(sindicato.getReclamacoes().get(0).contains("Aumento salarial"));
        assertEquals(1, admin.getHistoricoComandos().size());
    }

    @Test
    void testMultiplosComandos() {
        Sindicato sindicato = new Sindicato("Sindicato Geral");
        AdministradorSindicato admin = new AdministradorSindicato();

        Command c1 = new PagarMensalidadeCommand(sindicato, "Carlos", 50.0);
        Command c2 = new RegistrarReclamacaoCommand(sindicato, "Carlos", "Melhores condições");
        Command c3 = new PagarMensalidadeCommand(sindicato, "Ana", 50.0);

        admin.executarComando(c1);
        admin.executarComando(c2);
        admin.executarComando(c3);

        assertEquals(100.0, sindicato.getCaixa());
        assertEquals(1, sindicato.getReclamacoes().size());
        assertEquals(3, admin.getHistoricoComandos().size());
    }
}

