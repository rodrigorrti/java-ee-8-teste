package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.exception.EMinhaExcecao;
import br.com.bytebank.banco.modelo.Sexo;

public class TestaFluxo {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        System.out.println(Sexo.MASCULINO.toString());
        System.out.println(Sexo.FEMININO);
        metodo1();
        System.out.println("Fim do main");
    }


    private static void metodo1() {
        System.out.println("Ini do metodo1");
        try {
            metodo2();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Erro aqui");
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
            e.printStackTrace();
        } catch (EMinhaExcecao e) {
            System.out.println("Meu primeiro Erro aqui");
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro aqui");
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws Exception {
        System.out.println("Ini do metodo2");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        for (int i = 5; i >= 0; i--) {
            System.out.println(i);
            //int a = 10 / i;
        }

        throw new EMinhaExcecao("ErroERR");

        //System.out.println("Fim do metodo2");
    }
}
