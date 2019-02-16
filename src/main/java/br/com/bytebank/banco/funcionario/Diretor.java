package br.com.bytebank.banco.funcionario;

public class Diretor extends Funcionario implements Autenticavel {
    private int senha;

    public Diretor() {
        System.out.println("Criando um br.com.bytebank.banco.funcionario.Diretor");
    }

    @Override
    public double getBonificacao() {
        return super.getSalario() + 1000.0;
    }

    @Override
    public int getSenha() {
        return this.senha;
    }

    @Override
    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public boolean autentica(int senha) {
        AutenticacaoUtil u = new AutenticacaoUtil();
        return u.autentica(senha);
    }
}
