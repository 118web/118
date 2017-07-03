package service.impl;

import entity.Hibernate;
import dao.UserDao;
import service.UserService;

public class UserServiceIpm implements UserService  {
	private UserDao userDao;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public Hibernate ServiceQueryById(int id) {
	return userDao.queryById(id);
		
	
	}
	
}


