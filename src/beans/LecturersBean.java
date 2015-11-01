package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import persistanceService.LecturersDAO;

@ManagedBean(name="lecturersBean")
@RequestScoped
public class LecturersBean{

	private List<SelectItem> lecturers;
	private LecturersDAO lecturersDAO;

	public LecturersBean() {
		lecturers = new ArrayList<SelectItem>();
	}

	public final List<SelectItem> getLecturers() {
		return lecturers = returnLecturers();
	}

	public final void setLecturers(List<SelectItem> lecturers) {
		this.lecturers = lecturers;
	}

	public List<SelectItem> returnLecturers(){
		lecturersDAO = new LecturersDAO();
		lecturers = new ArrayList<SelectItem>();
		try {
			lecturers = lecturersDAO.returnLecturers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lecturers;
	}
	
}
