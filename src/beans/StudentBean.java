package beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Student;
import model.User;
import persistanceService.StudentDAO;

@ManagedBean(name="studentBean")
@RequestScoped
public class StudentBean{

	private Student student;
	private User user;
	private StudentDAO studentDAO;

	public StudentBean(){
		user = (User) BeanUtils.getSession().getAttribute("user");
		student = new Student(); //altfel ar fi null cand fac #{studentBean.student.name}
		
		//trebuie scos daca pag e completata de admin
		student.setName(user.getUsername());
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void createStudent(){
		studentDAO = new StudentDAO();
		try {
			studentDAO.insertStudent(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
