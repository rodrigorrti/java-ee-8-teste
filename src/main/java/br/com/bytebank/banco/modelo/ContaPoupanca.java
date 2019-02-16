package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta implements Tributavel {
    public ContaPoupanca(){
        super(0,0);
    }

    public ContaPoupanca(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public Double getValorImposto() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Conta Poupanca: " + super.toString();
    }
}
