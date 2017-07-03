package dao.impl;

import java.util.List;
import java.util.Properties;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LoginDao;
import entity.Login;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {


	public List<Login> findAll() {
		return getHibernateTemplate().loadAll(Login.class);
	}

	public Login find(int id) {
		return (Login) getHibernateTemplate().get(Login.class, id);
	}

	public List<Login> find(Properties prop) {
		return getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Login.class).add(
						Expression.allEq(prop)));
	}

	public void add(Login u) {
		getHibernateTemplate().save(u);

	}

	public void chage(Login u) {
		getHibernateTemplate().update(u);

	}

	public void delete(Login u) {
		getHibernateTemplate().delete(u);

	}

}
