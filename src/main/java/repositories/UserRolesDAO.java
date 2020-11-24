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

	public static void insert(UserRoles role) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(role);
		tx.commit();
	}

	public static void update(UserRoles role) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(role);
		tx.commit();
	}

	public static List<UserRoles> selectAll() {  // changed to static
		Session session = HibernateUtil.getSession();
		List<UserRoles> roleList = session.createQuery("from UserRoles", UserRoles.class).list();

		return roleList;
	}

	public static List<UserRoles> selectById(int id) {  // changed to static
		Session session = HibernateUtil.getSession();
		UserRoles roleList = session.get(UserRoles.class, id);

		List<UserRoles> list = session.createQuery("from UserRoles", UserRoles.class).list();

		return list;
	}

}
