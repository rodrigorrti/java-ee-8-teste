package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestaEncapsulamento {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente(1,2);
        conta.deposita(100);
        //System.out.println(conta.saca(200));
        System.out.println(conta.getSaldo());
        //conta.saldo -= 200;
        System.out.println(conta.getSaldo());

        Cliente p = new Cliente();
        //System.out.println(conta.getTitular().nome);
        //p.nome = "Paulo";
        conta.setTitular(p);
        //System.out.println(conta.tipo);
        System.out.println(conta.getTitular().getNome());
        System.out.println(conta.getAgencia());

        conta.getTitular().setProfissao("programador");
        System.out.println(conta.getTitular().getProfissao());

        Cliente c = conta.getTitular();
        System.out.println(c);
        System.out.println(conta.getTitular());
        System.out.println(p);

        conta.setTitular(new Cliente());

        System.out.println(c);
        System.out.println(conta.getTitular());
        System.out.println(p);
    }
}
