package beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BeanUtils {

	public static HttpSession getSession(){
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
}
