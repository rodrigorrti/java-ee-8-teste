package br.com.bytebank.banco.funcionario;

public class SistemaInterno {

    private int senha = 22;

    public void autentica(Autenticavel f) {
        if (f.autentica(this.senha)) {
            System.out.println("Pode entrar no sistema!");
        } else {
            System.out.println("Nao pode entrar");
        }
    }
}
