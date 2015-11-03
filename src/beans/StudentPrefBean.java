package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Student;
import persistanceService.StudentPrefDAO;

@ManagedBean(name="studentPrefBean")
@RequestScoped
public class StudentPrefBean{

	private Student student;
	private List<String> prefNumbers;
	private ProjectBean projectBean;
	private StudentPrefDAO studentPrefDAO;

	public StudentPrefBean(){
		student = new Student();
		prefNumbers = new ArrayList<String>();
	}
	
	public final Student getStudent() {
		return student;
	}

	public final void setStudent(Student student) {
		this.student = student;
	}

	public final List<String> getPrefNumbers() {
		return prefNumbers;
	}

	public final void setPrefNumbers(List<String> prefNumbers) {
		this.prefNumbers = prefNumbers;
	}

	public final ProjectBean getProjectBean() {
		return projectBean;
	}

	public final void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public void savePreferences(){
		studentPrefDAO = new StudentPrefDAO();
		try {
			studentPrefDAO.savePreferences(student, prefNumbers);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
