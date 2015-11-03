package persistanceService;

import java.sql.SQLException;
import java.util.List;

import model.Student;

public class StudentPrefDAO extends DBConnection{

	public void savePreferences(Student student, List<String> prefNumbers) throws SQLException{
		for(int i=0; i<prefNumbers.size(); i++){
			int prefNumberInt = Integer.parseInt(prefNumbers.get(i));
			getConnection().createStatement().executeUpdate(
					"insert into studentPref (student_id, pref_nr, project_id) values "
					+ "('" + student.getId() + "', '" + prefNumberInt + "', '" + i + "')");
		}
	  }

}
