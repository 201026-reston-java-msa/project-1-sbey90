package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.UserRoles;
import utils.HibernateUtil;

public class UserRolesDAO {

	public UserRolesDAO() {
		super();
	}

	public void insert(UserRoles role) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(role);
		tx.commit();
	}

	public void update(UserRoles role) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(role);
		tx.commit();
	}

	public List<UserRoles> selectAll() {
		Session session = HibernateUtil.getSession();
		List<UserRoles> roleList = session.createQuery("from UserRoles", UserRoles.class).list();

		return roleList;
	}

	public List<UserRoles> selectById(int id) {
		Session session = HibernateUtil.getSession();
		UserRoles roleList = session.get(UserRoles.class, id);

		List<UserRoles> list = session.createQuery("from UserRoles", UserRoles.class).list();

		return list;
	}

}
