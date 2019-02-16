package br.com.bytebank.banco.modelo;

import br.com.bytebank.banco.exception.SaldoInsulficienteException;

public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
        //System.out.println("br.com.bytebank.banco.entity.Conta Corrente criada!");
    }

    @Override
    public void saca(double valor) throws SaldoInsulficienteException {
         super.saca(valor + 0.2);
    }

    @Override
    public Double getValorImposto() {
        return super.getSaldo() * 0.01;
    }

    @Override
    public String toString() {
        return "Conta Corrente: " + super.toString();
    }
}
