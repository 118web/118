package dao;

import java.util.List;
import java.util.Properties;

import entity.Login;

public interface LoginDao {
	List<Login> findAll();
	Login find(int id);
	List<Login> find(Properties prop);
	void add(Login u);
	void chage(Login u);
	void delete(Login u);
}