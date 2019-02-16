package br.com.bytebank.banco.modelo;

public enum Sexo {
    MASCULINO(1, "Homem"), FEMININO(2, "Mulher");

    private int valor;
    private String descricao;

    private Sexo(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return super.toString() + " Código: "+ this.getValor() + " Descrição: "+ this.getDescricao();
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
