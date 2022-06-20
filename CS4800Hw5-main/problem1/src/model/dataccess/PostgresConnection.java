package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection implements DataBaseConnection {

	@Override
	public Connection getDataBaseConnection() throws SQLException, ClassNotFoundException {
		final String URL = "jdbc:postgresql://localhost:5432/authentication";
		
		final String USER = "postgres";
		
		final String PWD = "123";
		
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PWD);
		return con;
	}
	

}
