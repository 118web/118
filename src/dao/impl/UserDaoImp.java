package dao.impl;

import dao.UserDao;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import entity.Hibernate;

public class UserDaoImp implements UserDao{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	
	public Hibernate queryById(int id) {
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Hibernate photo= (Hibernate)session.get(Hibernate.class, id);
		session.getTransaction().commit();
		session.close();
		
		return photo;
}
}
