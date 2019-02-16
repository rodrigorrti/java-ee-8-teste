package br.com.bytebank.banco.modelo;

public class CalculadorDeImpoasto {

    private Double totalImposto = 0.0;

    public void registra(Tributavel t){
           this.totalImposto += t.getValorImposto();
    }

    public Double getTotalImposto(){
        return this.totalImposto;
    }
}
