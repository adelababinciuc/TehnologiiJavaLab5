package persistanceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import model.Project;

public class ProjectDAO extends DBConnection{

	public void insertProject(Project project) throws SQLException{

		getConnection().createStatement().executeUpdate(
				"insert into project (title, description, coordinator) values "
				+ "('" + project.getTitle() + "', '" + project.getDescription() + "', '" + project.getCoordinator().getId() + "')");

	  }
	
	public List<SelectItem> getAllProjects() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("select * from project");
		
		List<SelectItem> projects = new ArrayList<SelectItem>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			projects.add(new SelectItem(rs.getString("project_id"), rs.getString("title")));
		}

		return projects;
	}
}
