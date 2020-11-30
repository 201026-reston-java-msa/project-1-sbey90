package utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import exceptions.InitializerErrorException;

public class HibernateUtil { // Session Factory
	
	private static Logger log = Logger.getLogger(HibernateUtil.class);
	
	private static Session ses;
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	
	public HibernateUtil() {
		super();
	}
	

	public static Session getSession() {
		
		if(ses == null) {
			
			ses = sf.openSession();
			log.info("Obtained current session.");
		} else {
			log.warn("Unable to obtain session.");
			throw new InitializerErrorException("Unable to connect to the database."); 
			
		}
		
		return ses;
		
	}
			
			// added final 
	
//	Configuration configuration = new Configuration();
//	configuration.configure("hibernate.cfg.xml");
//	
//	 SessionFactory sf = configuration.buildSessionFactory();
	
	

//	
//	
//	public static Session getSession() {
//		sf.getCurrentSession();  // added
//		
//		if(ses == null) {
//			ses = sf.openSession();
//		}
//		return ses;
//	}
	
//	public static void closeSes() {
//		ses.close();
//		sf.close();
//	}

}
