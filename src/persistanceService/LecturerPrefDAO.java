package persistanceService;

import java.sql.SQLException;
import java.util.List;

import model.Lecturer;
import model.Student;

public class LecturerPrefDAO extends DBConnection{

	public void savePreferences(Lecturer lecturer, List<String> prefNumbers) throws SQLException{
		for(int i=0; i<prefNumbers.size(); i++){
			int prefNumberInt = Integer.parseInt(prefNumbers.get(i));
			getConnection().createStatement().executeUpdate(
					"insert into lecturerPref (lecturer_id, pref_nr, student_id) values "
					+ "('" + lecturer.getId() + "', '" + prefNumberInt + "', '" + i + "')");
		}
	  }

}
