package service;

import entity.Login;

public interface LoginService{

	Login login(Login u);
	boolean regist(Login u);
}
