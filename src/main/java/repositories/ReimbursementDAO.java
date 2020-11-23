package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Reimbursement;
import utils.HibernateUtil;

public class ReimbursementDAO {
	
	public ReimbursementDAO() {
		super();
	}
	
	public static void insert(Reimbursement r) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(r);
		tx.commit();
	}
	
	public static void update(Reimbursement r) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(r);
		tx.commit();
	}
	
	public static Reimbursement selectyById(int id) { // changed to static
		Session session = HibernateUtil.getSession();
		Reimbursement reimbursement = session.get(Reimbursement.class, id);
		
		return reimbursement;
	}
	
	public static List<Reimbursement> selectAll() {  // changed to static
		Session session = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = session.createQuery("from Reimbursement", Reimbursement.class).list();
		
		return reimList;
	}
	
	public static void delete(Reimbursement r) {  // changed to static
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(r);
		tx.commit();
	}

}
