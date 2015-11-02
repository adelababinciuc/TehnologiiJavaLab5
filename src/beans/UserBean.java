package beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import persistanceService.UserDAO;
import model.User;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {

	private User user;
	private UserDAO userDAO;
	private List<SelectItem> roles;

	public UserBean() {
		user = new User();		
		populateRoles();
	}

	public void createUser(){
		userDAO = new UserDAO();
		try {
			userDAO.insertUser(user);
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void populateRoles(){
		roles = new ArrayList<SelectItem>();
		roles.add(new SelectItem("STUDENT", "STUDENT"));
		roles.add(new SelectItem("LECTURER", "LECTURER"));
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<SelectItem> getRoles() {
        return roles;
    }
}
