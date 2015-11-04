package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import model.Project;
import persistanceService.ProjectDAO;

@ManagedBean(name="projectBean")
@RequestScoped
public class ProjectBean{

	private Project project;
	private List<Project> projectList;
	private List<SelectItem> projects;
	private int chosenLecturerID;
	private ProjectDAO projectDAO;

	public ProjectBean(){
		project = new Project(); 
		chosenLecturerID = 0;
	}
	
	@PostConstruct
    public void init() {
		projectList = getProjectListDB();
    }
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public final List<Project> getProjectList() {
		return projectList;
	}

	public final void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public final List<SelectItem> getProjects() {
		return projects;
	}

	public final void setProjects(List<SelectItem> projects) {
		this.projects = projects;
	}

	public int getChosenLecturerID() {
		return chosenLecturerID;
	}

	public void setChosenLecturerID(int chosenLecturerID) {
		this.chosenLecturerID = chosenLecturerID;
	}

	public void createProject(){
		projectDAO = new ProjectDAO();		
		try {
			project.setCoordinator(chosenLecturerID);
			projectDAO.insertProject(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Project> getProjectListDB(){
		projectDAO = new ProjectDAO();
		projectList = new ArrayList<Project>();
		try {
			projectList = projectDAO.getProjectListDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
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
