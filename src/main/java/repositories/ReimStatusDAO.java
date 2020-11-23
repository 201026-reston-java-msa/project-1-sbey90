package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.ReimStatus;
import models.ReimType;
import utils.HibernateUtil;

public class ReimStatusDAO {

	public ReimStatusDAO() {
		super();
	}

	public static void insert(ReimStatus status) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(status);
		tx.commit();
	}

	public static void update(ReimStatus status) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(status);
		tx.commit();
	}

	public static List<ReimStatus> selectAll() { // changed to static
		Session session = HibernateUtil.getSession();
		List<ReimStatus> statusList = session.createQuery("from ReimStatus", ReimStatus.class).list();

		return statusList;
	}

	public static List<ReimStatus> selectById(int id) {  // changed to static
		Session session = HibernateUtil.getSession();
		ReimStatus status = session.get(ReimStatus.class, id);

		List<ReimStatus> statusList = session.createQuery("from ReimStatus", ReimStatus.class).list();

		return statusList;

	}
}
