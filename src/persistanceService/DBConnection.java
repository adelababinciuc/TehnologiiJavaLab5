package persistanceService;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	@Resource(name="jdbc/spaDB")
	protected DataSource ds;
	
	public DBConnection(){
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/spaDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		if(ds==null)
			throw new SQLException("Can't get data source");
		    
		//get database connection
		Connection con = ds.getConnection();
		    
		if(con==null)
			throw new SQLException("Can't get database connection");
		
		return con;
	}
}
