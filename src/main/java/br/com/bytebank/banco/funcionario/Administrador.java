package br.com.bytebank.banco.funcionario;

public class Administrador extends Funcionario implements Autenticavel {
    private int senha;

    @Override
    public double getBonificacao() {
        return 0;
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
