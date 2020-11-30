package repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.User;
import utils.HibernateUtil;


public class UserDAO {
	
	private static Session session = HibernateUtil.getSession();
	
	private static Logger log = Logger.getLogger(UserDAO.class);

	public UserDAO() {
		super();
	}

	public static void insert(User user) {  // Changed to static and return type (was void) -- testing
		session.beginTransaction();
		
		try {
			session.save(user);
		} catch (HibernateException e) {
			log.warn("Unable to insert user into the database.", e);
		}
		
		session.getTransaction().commit();
//		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//
//		session.save(user);
//		tx.commit();
			
		
	}

	public static void update(User user) {   // Changed to static -- testing
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.update(user);
		tx.commit();
		
	}

	public static List<User> selectById(int id) {  // changed to static 
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, id);

		List<User> userList = session.createQuery("from User", User.class).list();

		return userList;
	}
	
	public static User selectByUsername(String username) {    // Changed to static -- testing
		Session session = HibernateUtil.getSession();

		List<User> userList = session.createQuery("from User where username='" + username + "'" + User.class).list();
		
		if(userList.size() == 0) {
			log.warn("Username is null.");
			return null;
		}
		log.info("Successfully retrieved username from the Database.");
		return userList.get(0);
		
	}
	
	public static List<User> selectAll() {   // Changed to static -- testing
		Session session = HibernateUtil.getSession();
		
		List<User> userList = session.createQuery("from User", User.class).list();
		
		return userList;
	}
	
	public static void delete(User r) {   // Changed to static -- testing
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(r);
		tx.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
