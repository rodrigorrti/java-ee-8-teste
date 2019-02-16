package br.com.bytebank.banco.javaIO;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class TestaJavaIO {
    public static void main(String[] args) throws IOException {

        //Leitura
        InputStream fs = new FileInputStream("..\\bytebank\\teste.txt");
        //InputStream fs = System.in;
        Reader sr = new InputStreamReader(fs);
        BufferedReader br = new BufferedReader(sr);
        //Escrita
        OutputStream fos = new FileOutputStream("..\\bytebank\\teste2.txt");
        //OutputStream fos = System.out;
        Writer sw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(sw);

        //System.out.println(fs.read());
        //System.out.println(sr.read());
        String linha = br.readLine();
        while (linha != null && !linha.isEmpty()) {
            bw.append("Rodrigo->" + linha);
            bw.newLine();
            bw.flush();
            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();
        bw.close();

        ////FileWriter
        FileWriter fw = new FileWriter("..\\bytebank\\teste3.txt");
        fw.write("Teste com fileWriter");
        fw.write(System.lineSeparator());
        fw.flush();
        fw.write("Teste com fileWriter");
        fw.close();

        BufferedWriter bfw = new BufferedWriter(new FileWriter("..\\bytebank\\teste4.txt"));
        bfw.write("Teste com FileWriter e Buffered Writer com Decorator");
        bfw.newLine();
        bfw.newLine();
        bfw.write("Fim");
        bfw.close();

        PrintStream ps = new PrintStream("..\\bytebank\\teste5.txt");
        //PrintWriter ps = new PrintWriter("teste5.txt");
        ps.println("Teste com PrintStream");
        ps.println();
        ps.println();
        ps.println(10);
        ps.close();

        System.out.println("------Scanner------");

        Scanner scan = new Scanner(new File("..\\bytebank\\contas.csv"), "UTF-8");
        //scan.forEachRemaining(item-> System.out.println(item));
        while (scan.hasNextLine()){
            String l = scan.nextLine();
            System.out.println(l);

            String[] valores = l.split(",");
            System.out.println(Arrays.toString(valores));

            Scanner linhaS = new Scanner(l).useDelimiter(",");
            while (linhaS.hasNextLine()) {
                System.out.println(linhaS.next());
            }
            linhaS.close();

            System.out.println(String.format(new Locale("pt","BR"),"String %10s,Numero %04d, Float %.2f - Float casas %12.2f", "Rod", 22,4.101,4.101));
        }
        scan.close();

    }

}
