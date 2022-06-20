package model.dataccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {
	
	private static LoginDataAccess instance;
	
	public static LoginDataAccess getInstance() {
		if (instance == null) {
			instance = new LoginDataAccess();
		}
		return instance;
	}

	public boolean verifyCredentials() throws ClassNotFoundException, SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		DataBaseConnection conection = connectionFactory.getConnection("postgres");
		
		final PreparedStatement stmt = conection.getDataBaseConnection().prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, User.getInstance().getUserName());
		stmt.setString(2, User.getInstance().getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}

