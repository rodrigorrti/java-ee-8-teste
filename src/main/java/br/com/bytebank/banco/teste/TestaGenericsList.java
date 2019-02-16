package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

import java.lang.reflect.Array;
import java.util.*;

public class TestaGenericsList {
    public static void main(String[] args) {

        ArrayList<Conta> contas = new ArrayList<Conta>();
        LinkedList<Conta> contasLinked = new LinkedList<>();
        Collection<Conta> contasVectorThreadSafe = new Vector<>();
        Collection<Conta> contasSetNonDuplicado = new HashSet<>();

        Conta cc0 = new ContaCorrente(1, 1);
        Conta cc1 = new ContaPoupanca(1, 2);
        Conta cc2 = new ContaCorrente(1, 3);
        Conta cc2Repetido = new ContaCorrente(1, 3);

        contas.add(cc0);
        contas.add(cc2);
        contas.add(cc2);
        System.out.println("---------------------------------");
        System.out.println("Tamanho da lista: " + contas.size());

        contasLinked.add(cc0);
        contasLinked.add(cc2);
        contasLinked.add(cc2);
        System.out.println("---------------------------------");
        System.out.println("Tamanho da contasLinked: " + contasLinked.size());

        contasVectorThreadSafe.add(cc0);
        contasVectorThreadSafe.add(cc2);
        contasVectorThreadSafe.add(cc2);
        System.out.println("---------------------------------");
        System.out.println("Tamanho da contasVectorThreadSafe: " + contasVectorThreadSafe.size());

        contasSetNonDuplicado.add(cc0);
        contasSetNonDuplicado.add(cc2);
        contasSetNonDuplicado.add(cc2);
        System.out.println("---------------------------------");
        System.out.println("Tamanho da contasSetNonDuplicado: " + contasSetNonDuplicado.size());

        System.out.println(contas.get(1));
        contas.remove(cc1);
        System.out.println("Tamanho da lista: " + contas.size());
        System.out.println(contas.get(1));

        System.out.println("---------------------------------");
        for (Conta oRef : contas) {
            System.out.println(oRef.getNumero());
        }

        System.out.println("Já existe cc2Repetido? " + contas.contains(cc2Repetido));

        System.out.println("---------------------------------");
        for (Conta oRef : contas) {
            if (oRef.equals(cc2Repetido))
                System.out.println("Já existe cc2Repetido For? " + contas.contains(cc2Repetido));
        }

        Integer i = Integer.valueOf(1);
        int a = Integer.parseInt("10");
        System.out.println(a + i);


        System.out.println("Integer 4B: " + Integer.MAX_VALUE + " - " + Integer.MIN_VALUE);
        System.out.println("float 4B: " + Float.MAX_VALUE + " - " + Integer.MIN_VALUE);

        System.out.println("Long 8B: " + Long.MAX_VALUE + " - " + Long.MIN_VALUE);
        System.out.println("Double 8B: " + Double.MAX_VALUE + " - " + Double.MIN_VALUE);

    }
}
