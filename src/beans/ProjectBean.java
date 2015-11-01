package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Project;
import persistanceService.ProjectDAO;

@ManagedBean(name="projectBean")
@RequestScoped
public class ProjectBean{

	private Project project;
	private ProjectDAO projectDAO;

	public ProjectBean(){
		project = new Project(); 
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void createProject(){
		projectDAO = new ProjectDAO();
		try {
			projectDAO.insertProject(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
