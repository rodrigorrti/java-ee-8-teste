package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestaConstructor {
    public static void main(String[] args) {
        System.out.println(Conta.getTotal());

        Conta conta = new ContaCorrente(1,2);
        Conta conta2 = new ContaCorrente(1,2);
        Conta conta3 = new ContaCorrente(1,2);

        System.out.println(conta.getDigito());
        System.out.println(conta2.getDigito());
        System.out.println(conta3.getDigito());

        System.out.println(Conta.getTotal());


        //teste de Wrapper
        Integer i;
        i = 10;
        System.out.println(i);
        Double d;
        d = (1.0);
        System.out.println(d.toString());
    }
}
