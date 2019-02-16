package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import com.sun.security.ntlm.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestaListaOrdenadaClasseInternaAnoninaLambda {
    public static void main(String[] args) {
        Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(10.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        System.out.println("---------Imprimindo toString da Classe---------");
        System.out.println(lista);
        System.out.println("---------Imprimindo forEach lambda---------");
        lista.stream().forEach(item -> System.out.print(" Numero conta " + item.getNumero()));
        System.out.println("\n---------Imprimindo forEach lambda reduzido---------");
        lista.stream().forEach(System.out::print);
        System.out.println("\n---------Imprimindo forEach lambda reduzido com filter---------");
        lista.stream().filter(item -> item.getNumero() < 12).forEach(System.out::print);

        System.out.println("\n---------Imprimindo ordenado por numero---------");
        lista.sort(new NumeroContaComparator());
        lista.forEach(System.out::println);

        System.out.println("\n---------Imprimindo ordenado por Titular---------");
        lista.sort(new TitularContaComparator());
        lista.forEach(item1 -> System.out.println(item1.getTitular().getNome()));

        System.out.println("\n---------Imprimindo ordenado por numero Antigo---------");
        Collections.sort(lista, new NumeroContaComparator());
        lista.forEach(System.out::println);

        System.out.println("\n---------Imprimindo ordenado por saldo Ordem Natural da Conta---------");
        Collections.sort(lista);
        lista.forEach(System.out::println);

        ArrayList<Integer> listaInt = new ArrayList<>();
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(3);
        listaInt.add(4);
        listaInt.add(5);
        System.out.println(listaInt);
        Collections.shuffle(listaInt);
        System.out.println(listaInt);

        System.out.println("\n---------Imprimindo ordenado por Titular Classe Interna Anonima---------");
        lista.sort(new Comparator<Conta>() {

            @Override
            public int compare(Conta c1, Conta c2) {
                return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
            }
        });
        lista.forEach(item1 -> System.out.println(item1.getTitular().getNome()));

        System.out.println("\n---------Imprimindo ordenado por Titular Lambda---------");
        lista.sort((Conta c1, Conta c2) -> {
            return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
        });
        lista.forEach(item1 -> System.out.println(item1.getTitular().getNome()));

        System.out.println("\n---------Imprimindo ordenado por Titular Lambda correto---------");
        lista.sort((c1, c2) -> c1.getTitular().getNome().compareTo(c2.getTitular().getNome()));
        lista.forEach(item1 -> System.out.println(item1.getTitular().getNome()));
    }
}

class TitularContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
    }
}

class NumeroContaComparator implements Comparator<Conta> {
    @Override
    public int compare(Conta c1, Conta c2) {

//        if (c1.getNumero() < c2.getNumero()) {
//            return -1;
//        }
//        if (c1.getNumero() > c2.getNumero()) {
//            return 1;
//        }
//        return c1.getNumero() - c2.getNumero();
        return Integer.compare(c1.getNumero(), c2.getNumero());
    }
}
