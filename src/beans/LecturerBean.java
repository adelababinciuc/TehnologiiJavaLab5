package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import model.Lecturer;
import persistanceService.LecturerDAO;

@ManagedBean(name="lecturerBean")
@RequestScoped
public class LecturerBean{

	private Lecturer lecturer;
	private List<Lecturer> lecturerList;
	private List<SelectItem> lecturers;
	private LecturerDAO lecturerDAO;

	public LecturerBean(){
		lecturer = new Lecturer();
		lecturers = getAllLecturers();
	}
	
	@PostConstruct
    public void init() {
		lecturerList = getLecturerListDB();
    }
	
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer Lecturer) {
		this.lecturer = Lecturer;
	}

	public final List<Lecturer> getLecturerList() {
		return lecturerList;
	}

	public final void setLecturerList(List<Lecturer> lecturerList) {
		this.lecturerList = lecturerList;
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
	
	public List<Lecturer> getLecturerListDB(){
		lecturerDAO = new LecturerDAO();
		lecturerList = new ArrayList<Lecturer>();
		try {
			lecturerList = lecturerDAO.getLecturerListDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lecturerList;
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
