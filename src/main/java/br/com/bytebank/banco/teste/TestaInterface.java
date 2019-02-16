package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.funcionario.*;
import br.com.bytebank.banco.modelo.*;

public class TestaInterface {
    public static void main(String[] args) {
        Gerente g = new Gerente();
        g.setSenha(22);

        Administrador a = new Administrador();
        a.setSenha(22);

        Cliente c = new Cliente();
        c.setSenha(221);

        Autenticavel d = new Diretor();
        d.setSenha(22);

        SistemaInterno s = new SistemaInterno();
        s.autentica(g);
        s.autentica(a);
        s.autentica(c);
        s.autentica(d);

        ContaCorrente cc=new ContaCorrente(1,2);
        cc.deposita(1000);
        Tributavel cp = new ContaPoupanca();
        ((ContaPoupanca) cp).deposita(100);
        Tributavel seguro = new SeguroDeVida();

        System.out.println("br.com.bytebank.banco.entity.Tributavel");
        CalculadorDeImpoasto calc = new CalculadorDeImpoasto();
        System.out.println(calc.getTotalImposto());
        calc.registra(cc);
        System.out.println(calc.getTotalImposto());
        calc.registra(cp);
        System.out.println(calc.getTotalImposto());
        calc.registra(seguro);
        System.out.println(calc.getTotalImposto());
    }
}
