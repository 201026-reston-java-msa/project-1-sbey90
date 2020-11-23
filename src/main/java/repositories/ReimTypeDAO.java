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

	public void insert(ReimType type) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(type);
		tx.commit();
	}

	public void update(ReimType type) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(type);
		tx.commit();
	}

	public List<ReimType> selectById(int id) {
		Session session = HibernateUtil.getSession();
		ReimType type = session.get(ReimType.class, id);

		List<ReimType> typeList = session.createQuery("from ReimType", ReimType.class).list();

		return typeList;
	}

	public List<ReimType> selectAll() {
		Session session = HibernateUtil.getSession();

		List<ReimType> typeList = session.createQuery("from ReimType", ReimType.class).list();

		return typeList;

	}

}
