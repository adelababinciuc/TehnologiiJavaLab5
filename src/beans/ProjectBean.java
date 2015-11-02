package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Project;
import persistanceService.LecturerDAO;
import persistanceService.ProjectDAO;

@ManagedBean(name="projectBean")
@RequestScoped
public class ProjectBean{

	private Project project;
	private String chosenLecturerID;
	private ProjectDAO projectDAO;

	public ProjectBean(){
		project = new Project(); 
		chosenLecturerID = "";
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getChosenLecturerID() {
		return chosenLecturerID;
	}

	public void setChosenLecturerID(String chosenLecturerID) {
		this.chosenLecturerID = chosenLecturerID;
	}

	public void createProject(){
		projectDAO = new ProjectDAO();		
		try {
			project.setCoordinator(new LecturerDAO().getLecturer(chosenLecturerID));
			projectDAO.insertProject(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
