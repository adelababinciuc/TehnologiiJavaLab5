package persistanceService;

import java.sql.SQLException;

import model.Student;

public class StudentDAO extends DBConnection{

	public void insertStudent(Student student) throws SQLException{

//	    getConnection().createStatement().executeUpdate("create table student(student_id varchar(45),"
//	            +" name varchar(45),"
//	            +" cnp varchar(45),"
//	    		+" placeOfBirth varchar(45),");

		getConnection().createStatement().executeUpdate(
				"insert into student (name, cnp, placeOfBirth) values "
				+ "('" + student.getName() + "', '" + student.getCnp() + "', '" + student.getPlaceOfBirth() + "')");

	  }
}
