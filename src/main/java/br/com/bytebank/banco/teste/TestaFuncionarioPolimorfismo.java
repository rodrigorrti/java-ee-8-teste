package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.funcionario.*;

public class TestaFuncionarioPolimorfismo {
    public static void main(String[] args) {
        Funcionario g1 = new GerenteRegional();
        g1.setNome("Marcos");
        ((Gerente) g1).autentica(1);
        System.out.println(g1.getNome());
        ((Gerente) g1).manda();
        g1.setSalario(5000);

        Funcionario f = new EditorVideo();
        f.setSalario(2000.0);

        EditorVideo e = new EditorVideo();
        e.setSalario(2000);

        Diretor d = new Diretor();
        d.setSalario(8000.0);

        ControlaBonificacao c = new ControlaBonificacao();
        c.registra(g1);
        c.registra(f);
        c.registra(e);
        c.registra(d);
        System.out.println("Total de bonificacaoes: " + c.getSoma());

    }
}
