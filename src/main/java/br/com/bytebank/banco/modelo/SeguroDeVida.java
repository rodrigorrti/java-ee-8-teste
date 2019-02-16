package br.com.bytebank.banco.modelo;

public class SeguroDeVida implements Tributavel {

    @Override
    public Double getValorImposto() {
        return 42.0;
    }
}
