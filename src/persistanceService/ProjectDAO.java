package persistanceService;

import java.sql.SQLException;

import model.Project;

public class ProjectDAO extends DBConnection{

	public void insertProject(Project project) throws SQLException{

		getConnection().createStatement().executeUpdate(
				"insert into project (title, description, coordinator) values "
				+ "('" + project.getTitle() + "', '" + project.getDescription() + "', '" + project.getCoordinator().getId() + "')");

	  }
}
