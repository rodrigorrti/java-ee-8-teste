package br.com.bytebank.banco.funcionario;

public class EditorVideo extends Funcionario {
    public EditorVideo() {
        System.out.println("Criando Editor de Video");
    }

    @Override
    public double getBonificacao() {
        return 150;
    }
}
