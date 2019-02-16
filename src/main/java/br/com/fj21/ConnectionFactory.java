package br.com.fj21;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {

            /**
             * Class.forName é opcional a partir do Java 6 com JDBC 4
             */
            Properties p = new Properties();
            p.setProperty("user", "root");
            p.setProperty("password", "mysql@rrr612");

            p.store(new FileWriter("conf.properties"), "Arquivo de Senha:");

            Properties props = new Properties();
            props.load(new FileReader("conf.properties"));

            String login = props.getProperty("user");
            String senha = props.getProperty("password");
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/rodrigo?useTimezone=true&serverTimezone=UTC", "root", "mysql@rrr612");
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            System.out.println("Conectado!");
        }
    }
}
