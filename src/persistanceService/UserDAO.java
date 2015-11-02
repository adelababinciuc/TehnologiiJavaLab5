package persistanceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO extends DBConnection{

	public void insertUser(User user) throws SQLException{
		getConnection().createStatement().executeUpdate(
				"insert into userAccount (username, password, role) values "
				+ "('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getRole() + "')");

	}
	
	public User getUser(String username, String password) throws SQLException{
		PreparedStatement ps = getConnection().prepareStatement(
		   "select * from userAccount where (username = '" + username + "' and password = '" + password + "')"); 
	
		//get user from database
		ResultSet result =  ps.executeQuery();
	
		User currentUser = null;
		while(result.next()){
			currentUser = new User(result.getString("username"), result.getString("password"), result.getString("role"));
		}
		
		return currentUser;
	}
}
