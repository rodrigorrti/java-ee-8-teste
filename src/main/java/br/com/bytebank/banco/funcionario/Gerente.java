package br.com.bytebank.banco.funcionario;

public class Gerente extends Funcionario implements Autenticavel {

    private int senha;

    public Gerente() {
        System.out.println("Criando um br.com.bytebank.banco.funcionario.Gerente!");
    }

    @Override
    public double getBonificacao() {
        return super.getSalario();
    }

    public void manda() {
        System.out.println("Execute a ordem");
    }

    @Override
    public int getSenha() {
        return this.senha;
    }

    @Override
    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        AutenticacaoUtil u = new AutenticacaoUtil();
        return u.autentica(senha);
    }

}
