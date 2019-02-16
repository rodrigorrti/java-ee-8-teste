package br.com.bytebank.banco.funcionario;

public interface Autenticavel {

    public abstract int getSenha();

    public abstract void setSenha(int senha);

    public abstract boolean autentica(int senha);
}
