package model.dataccess;

public class ConnectionFactory {

	public DataBaseConnection getConnection(String database) {
		if(database.equalsIgnoreCase("postgres")) {
			return new PostgresConnection();
		}
		else {
			return null;
		}
	}
}
