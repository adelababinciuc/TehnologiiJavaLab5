package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import model.Lecturer;
import persistanceService.LecturerDAO;

@ManagedBean(name="lecturerBean")
@RequestScoped
public class LecturerBean{

	private Lecturer lecturer;
	private List<SelectItem> lecturers;
	private LecturerDAO lecturerDAO;

	public LecturerBean(){
		lecturer = new Lecturer();
		lecturers = getAllLecturers();
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer Lecturer) {
		this.lecturer = Lecturer;
	}

	public final List<SelectItem> getLecturers() {
		return lecturers;
	}

	public final void setLecturers(List<SelectItem> lecturers) {
		this.lecturers = lecturers;
	}
	
	public void createLecturer(){
		lecturerDAO = new LecturerDAO();
		try {
			lecturerDAO.insertLecturer(lecturer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<SelectItem> getAllLecturers(){
		lecturerDAO = new LecturerDAO();
		lecturers = new ArrayList<SelectItem>();
		try {
			lecturers = lecturerDAO.getAllLecturers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lecturers;
	}
}
