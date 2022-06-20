package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import view.LoginSuccessView;

public class LoginBusiness {
	
	private static LoginBusiness instance;
	
	private String userName;
	
	private String password;
	
	private LoginBusiness(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	public static LoginBusiness getInstance() {
		if (instance == null) {
			instance = new LoginBusiness(null, null);
		}
		return instance;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String user) {
		userName = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String passWord) {
		password = passWord;
	}
	
	public boolean verifyCredentials() throws ClassNotFoundException, SQLException {
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}
		
		User user = User.getInstance();
		user.setPassword(password);
		user.setUserName(userName);
		
		if(!(new LoginDataAccess().verifyCredentials())) {
			throw new MessageException("incorrect credentials.");
		}
		
		return true;
		
	
				
	}
	
}
