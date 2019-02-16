package br.com.bytebank.banco.exception;

public class EMinhaExcecao extends RuntimeException {

    public EMinhaExcecao() {
        super();
    }

    public EMinhaExcecao(String message) {
        super(message);
    }
}
