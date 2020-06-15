package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp-json-ajax?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar no banco de dados!");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
