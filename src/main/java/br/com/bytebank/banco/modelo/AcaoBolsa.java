package br.com.bytebank.banco.modelo;

public class AcaoBolsa implements Tributavel {
    @Override
    public Double getValorImposto() {
        return 10.0;
    }
}
