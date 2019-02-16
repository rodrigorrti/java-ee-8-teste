package br.com.agenda;

import java.io.FileReader;
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
            String login;
            String senha;
            try {
                Properties props = new Properties();
                props.load(new FileReader("conf.properties"));

                login = props.getProperty("user");
                senha = props.getProperty("password");
            } catch (IOException e) {
                login = "root";
                senha = "mysql@rrr612";
            }
            //Class.forName("com.mysql.jdbc.Driver"); --Depreciated
            return DriverManager.getConnection("jdbc:mysql://localhost/rodrigo?useTimezone=true&serverTimezone=UTC", login, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            System.out.println("Conectado!");
        }
    }
}
