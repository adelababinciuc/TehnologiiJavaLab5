package persistanceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO extends DBConnection{

	public void insertStudent(Student student) throws SQLException{

		getConnection().createStatement().executeUpdate(
				"insert into student (name, cnp, placeOfBirth) values "
				+ "('" + student.getName() + "', '" + student.getCnp() + "', '" + student.getPlaceOfBirth() + "')");

	  }
	
	public List<Student> getStudentListDB() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("select * from student");
		
		List<Student> studentList = new ArrayList<Student>();

		ResultSet result = ps.executeQuery();
		while (result.next()) {
			studentList.add(new Student(result.getInt("student_id"), result.getString("name"), result.getString("cnp"), result.getString("placeofbirth")));
		}

		return studentList;
	}
}
