package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestaCliente {
    public static void main(String[] args) {
        Cliente paulo = new Cliente();
        paulo.setNome("Paulo");
        paulo.setCpf("22222");
        paulo.setProfissao("programador");

        Conta contaPaulo = new ContaCorrente(1,2);
        contaPaulo.setTitular(paulo);

        System.out.println(contaPaulo.getTitular().getNome());

        System.out.println(paulo.getClass().getSimpleName());
        System.out.println(paulo.getClass().getCanonicalName());
    }
}
