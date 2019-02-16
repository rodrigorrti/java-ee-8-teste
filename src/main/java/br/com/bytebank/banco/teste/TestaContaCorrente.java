package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.exception.SaldoInsulficienteException;

public class TestaContaCorrente {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(1,2);
        ContaPoupanca cp = new ContaPoupanca(3,4);

        cc.deposita(100);
        cp.deposita(200);

        try {
            cc.transfere(100,cp);
        } catch (SaldoInsulficienteException e) {
            System.out.println(e.getMessage());
        }
        cc.getSaldo();
        cp.getSaldo();
    }
}
