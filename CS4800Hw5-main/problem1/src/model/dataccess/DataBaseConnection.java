package model.dataccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnection {
	Connection getDataBaseConnection() throws SQLException, ClassNotFoundException;
}
