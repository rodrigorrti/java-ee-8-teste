package br.com.bytebank.banco.exception;

public class SaldoInsulficienteException extends Exception {

    public SaldoInsulficienteException(){
        super("Saldo insuficiente!");
    }

    public SaldoInsulficienteException(String msg){
        super(msg);
    }
}
