package br.com.bytebank.banco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	public static Connection getConnection() {

		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			String url = "jdbc:jtds:sqlserver://tcmdados03:1433/PASSAPORTE";

			return DriverManager.getConnection(url, "usr_passaporte", "passaporte#USR");

		} catch (Exception e) {

			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
