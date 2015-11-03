package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import model.Project;
import persistanceService.LecturerDAO;
import persistanceService.ProjectDAO;

@ManagedBean(name="projectBean")
@RequestScoped
public class ProjectBean{

	private Project project;
	private List<SelectItem> projects;
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

	public final List<SelectItem> getProjects() {
		return projects;
	}

	public final void setProjects(List<SelectItem> projects) {
		this.projects = projects;
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
	
	public List<SelectItem> getAllProjects(){
		projectDAO = new ProjectDAO();
		projects = new ArrayList<SelectItem>();
		try {
			projects = projectDAO.getAllProjects();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
}
