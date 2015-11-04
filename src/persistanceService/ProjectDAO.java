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
				+ "('" + project.getTitle() + "', '" + project.getDescription() + "', '" + project.getCoordinator() + "')");

	  }
	
	public List<Project> getProjectListDB() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("select * from project");
		
		List<Project> projectList = new ArrayList<Project>();

		ResultSet result = ps.executeQuery();
		while (result.next()) {
			projectList.add(new Project(result.getInt("project_id"), result.getString("title"), result.getString("description"), Integer.parseInt(result.getString("coordinator"))));
		}

		return projectList;
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
