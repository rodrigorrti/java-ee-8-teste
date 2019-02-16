package br.com.bytebank.banco.funcionario;

public class AutenticacaoUtil {
    private int senha = 22;

    public int getSenha() {
        return this.senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        if (this.getSenha() == senha) {
            return true;
        }
        return false;
    }
}
