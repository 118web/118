package service.impl;

import java.util.List;
import java.util.Properties;

import org.kie.api.KieBase;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import service.LoginService;
import dao.LoginDao;
import entity.Login;

public class LoginServiceImpl implements LoginService {
	private LoginDao ud;

	public Login login(Login u) {
		Properties prop = new Properties();
		prop.setProperty("username", u.getUsername());
		prop.setProperty("password", u.getPassword());
		List<Login> users = ud.find(prop);

		if (users.isEmpty())
			return null;
		else
			return users.get(0);
	}

	public boolean regist(Login u) {
		Properties prop = new Properties();
		prop.setProperty("username", u.getUsername());
		List<Login> users = ud.find(prop);

		if (users.isEmpty()) {
			ud.add(u);
			return true;
		} else
			return false;

	}

	public LoginDao getUd() {
		return ud;
	}

	public void setUd(LoginDao ud) {
		this.ud = ud;
	}
	
	
	
	
	
	


}
