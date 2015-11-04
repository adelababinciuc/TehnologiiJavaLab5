package persistanceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import model.Lecturer;

public class LecturerDAO extends DBConnection{

	public void insertLecturer(Lecturer lecturer) throws SQLException{
		getConnection().createStatement().executeUpdate(
				"insert into lecturer (name, specialization) values "
				+ "('" + lecturer.getName() + "', '" + lecturer.getSpecialization() + "')");
	}
	
	public List<Lecturer> getLecturerListDB() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("select * from lecturer");
		
		List<Lecturer> lecturerList = new ArrayList<Lecturer>();

		ResultSet result = ps.executeQuery();
		while (result.next()) {
			lecturerList.add(new Lecturer(result.getInt("lecturer_id"), result.getString("name"), result.getString("specialization")));
		}

		return lecturerList;
	}
	
	public List<SelectItem> getAllLecturers() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("select * from lecturer");
		
		List<SelectItem> lecturers = new ArrayList<SelectItem>();

		ResultSet result = ps.executeQuery();
		while (result.next()) {
			lecturers.add(new SelectItem(result.getString("lecturer_id"), result.getString("name")));
		}

		return lecturers;
	}
	
	public Lecturer getLecturer(String id) throws SQLException{
		PreparedStatement ps = getConnection().prepareStatement("select * from lecturer where (lecturer_id = '" + id + "')"); 
		
		ResultSet result =  ps.executeQuery();
	
		Lecturer currentLecturer = null;
		while(result.next()){
			currentLecturer = new Lecturer(result.getInt("lecturer_id"), result.getString("name"), result.getString("specialization"));
		}
		
		return currentLecturer;
	}
}
