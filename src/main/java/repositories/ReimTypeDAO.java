package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.ReimType;
import utils.HibernateUtil;

public class ReimTypeDAO {

	public ReimTypeDAO() {
		super();
	}

	public static void insert(ReimType type) { // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(type);
		tx.commit();
	}

	public static void update(ReimType type) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(type);
		tx.commit();
	}

	public static List<ReimType> selectById(int id) {  // changed to static
		Session session = HibernateUtil.getSession();
		ReimType type = session.get(ReimType.class, id);

		List<ReimType> typeList = session.createQuery("from ReimType", ReimType.class).list();

		return typeList;
	}

	public static List<ReimType> selectAll() {  // changed to static
		Session session = HibernateUtil.getSession();

		List<ReimType> typeList = session.createQuery("from ReimType", ReimType.class).list();

		return typeList;

	}

}
