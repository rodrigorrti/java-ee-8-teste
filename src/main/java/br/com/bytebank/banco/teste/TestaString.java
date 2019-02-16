package br.com.bytebank.banco.teste;

public class TestaString {

    public static void main(String[] args) {

        String nome = "Rodrigo";

        System.out.println(nome.toString());
        System.out.println(nome.toUpperCase());
        System.out.println(nome.replace("r",""));

        System.out.println(nome.charAt(1));

        for (char c : nome.toCharArray()){
            System.out.println(c);
        }

        System.out.println(nome.indexOf("odri"));
        System.out.println(nome.endsWith("go"));
        System.out.println(nome.substring(2) + nome.substring(2).length());


        for (String c : nome.split("o")){
            System.out.println(c);
        }
        String a = " ";
        System.out.println(a.trim().isEmpty());

        System.out.println(nome.contains("drigo"));

        String texto = "Socorram";
        texto = texto.concat("-");
        texto = texto.concat("me");
        texto = texto.concat(", ");
        texto = texto.concat("subi ");
        texto = texto.concat("no ");
        texto = texto.concat("ônibus ");
        texto = texto.concat("em ");
        texto = texto.concat("Marrocos");
        System.out.println(texto);

    }
}
