package persistanceService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import model.Lecturer;

public class LecturersDAO extends DBConnection {

	public List<SelectItem> returnLecturers() throws SQLException {
		Statement stmt = null;
		String query = "select lecturer_id, name from lecturer";

		List<SelectItem> lecturers = new ArrayList<SelectItem>();

		try {
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("lecturer_id");
				String name = rs.getString("name");
			
				SelectItem selectItem = new SelectItem(id, name);
				lecturers.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return lecturers;
	}
}
