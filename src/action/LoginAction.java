package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.LoginService;
import service.impl.LoginServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Login;

public class LoginAction extends ActionSupport {
	private Login user;
	private String password2;
	private LoginService us;
	private LoginServiceImpl sa;
	public String login() {
		
		Login u = us.login(user);
		if (u != null) {
			getSession().put("login_user", u);
			return SUCCESS;
		} else {
			addActionError("sorry your username or passowrd not true");
			return INPUT;
		}
	}

	public String regist() {
		if (password2.equals(user.getPassword())&&password2!=null&&user.getPassword()!=null) {
			if (us.regist(user))
				return SUCCESS;
			else {
				this.addActionError("sorry the user was existed");
				return INPUT;
			}
		} else {
			addActionError("sorry your password not same");
			return INPUT;
		}
	}

	public String logout() {
		getSession().clear();
		return SUCCESS;
	}
	
	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public LoginService getUs() {
		return us;
	}

	public void setUs(LoginService us) {
		this.us = us;
	}
	  public String  execute1() {     
	       // Blob z=request.getParameter("id");  
		   HttpServletRequest request=ServletActionContext.getRequest();

          String  t  =request.getParameter("testname");

               System.out.println(t);

	return SUCCESS;
	
  }
	private Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
}
