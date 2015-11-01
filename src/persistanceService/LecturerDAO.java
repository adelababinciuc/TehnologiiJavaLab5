package persistanceService;

import java.sql.SQLException;

import model.Lecturer;

public class LecturerDAO extends DBConnection{

	public void insertLecturer(Lecturer lecturer) throws SQLException{

		getConnection().createStatement().executeUpdate(
				"insert into lecturer (name, specialization) values "
				+ "('" + lecturer.getName() + "', '" + lecturer.getSpecialization() + "')");

	  }
}
