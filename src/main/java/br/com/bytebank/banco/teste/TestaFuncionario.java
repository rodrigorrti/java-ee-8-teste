package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.funcionario.Diretor;
import br.com.bytebank.banco.funcionario.EditorVideo;
import br.com.bytebank.banco.funcionario.Funcionario;
import br.com.bytebank.banco.funcionario.Gerente;

public class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario func = new EditorVideo();
        func.setNome("Joao");
        func.setSalario(2000);
        System.out.println(func.getNome() + " com bonificação "+ (func.getSalario() + func.getBonificacao()));

        Funcionario gerente = new Gerente();
        gerente.setNome("Maria");
        gerente.setSalario(2000);
        System.out.println(gerente.getNome() + " com bonificação "+ (gerente.getSalario() + gerente.getBonificacao()));
        System.out.println("Autenticado: " + ((Gerente) gerente).autentica(1));

        Funcionario diretor = new Diretor();
        diretor.setNome("Pedro");
        diretor.setSalario(2000);
        System.out.println(diretor.getNome() + " com bonificação "+ (diretor.getSalario() + diretor.getBonificacao()));
        ((Diretor) diretor).setSenha(1);
        System.out.println("Autenticado: " + ((Diretor) diretor).autentica(1));
    }
}
