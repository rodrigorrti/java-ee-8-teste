package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.exception.SaldoInsulficienteException;

public class TestaMetodo {
    public static void main(String[] args) {
        Conta joao = new ContaCorrente(1, 2);
        joao.deposita(10);
        System.out.println(joao.getSaldo());

        try {
            joao.saca(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Não conseguiu sacar");

        System.out.println(joao.getSaldo());

        Conta rodrigo = new ContaCorrente(1, 2);
        rodrigo.deposita(1000);

        System.out.println("Saldo joao " + joao.getSaldo());
        System.out.println("Saldo rodrigo " + rodrigo.getSaldo());
        try {
            rodrigo.transfere(200, joao);
        }catch (SaldoInsulficienteException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Saldo joao " + joao.getSaldo());
        System.out.println("Saldo rodrigo " + rodrigo.getSaldo());
    }
}
