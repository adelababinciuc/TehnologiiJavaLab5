package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Student;
import model.User;
import persistanceService.StudentDAO;

@ManagedBean(name="studentBean")
@RequestScoped
public class StudentBean{

	private Student student;
	private List<Student> studentList;
	private User user;
	private StudentDAO studentDAO;

	public StudentBean(){
		user = (User) BeanUtils.getSession().getAttribute("user");
		student = new Student(); //altfel ar fi null cand fac #{studentBean.student.name}
		
		//trebuie scos daca pag e completata de admin
		student.setName(user.getUsername());
	}
	
	@PostConstruct
    public void init() {
		studentList = getStudentListDB();
    }
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public final List<Student> getStudentList() {
		return studentList;
	}

	public final void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void createStudent(){
		studentDAO = new StudentDAO();
		try {
			studentDAO.insertStudent(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudentListDB(){
		studentDAO = new StudentDAO();
		studentList = new ArrayList<Student>();
		try {
			studentList = studentDAO.getStudentListDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
}
