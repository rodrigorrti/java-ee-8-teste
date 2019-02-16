package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Banco ByteBank!");
        Conta conta = new ContaCorrente(1,2);
        conta.setAgencia(10);
        conta.setTitular(new Cliente());
        //conta.saldo = 5 / 2;
        System.out.println(conta.getSaldo());
        //conta.saldo += 100;
        System.out.println(conta.getSaldo());

        //int sal;
        //System.out.println(sal);

        //Apenas um new, então temos apenas uma referencia
        Conta conta2 = new ContaCorrente(1,2);
        //conta2.saldo = 300;
        System.out.println(conta2.getSaldo());
        Conta conta3 = conta2;
        //conta2.saldo += 200;
        System.out.println(conta3.getSaldo());
        if (conta == conta2) {
            System.out.println("br.com.bytebank.banco.entity.Conta e conta2 iguais");
        }
        if (conta3 == conta2) {
            System.out.println("Conta3 e conta2 iguais");
        }

        //Na String não aponta para Referencia?
        String a = new String();
        a = "Rodrigo";
        System.out.println(a);
        String b = a;
        if (a == b) {
            System.out.println("a e b iguais");
        }
        a = "Joao";
        if (a == b) {
            System.out.println("a e b iguais");
        }
        System.out.println(b);
    }
}
