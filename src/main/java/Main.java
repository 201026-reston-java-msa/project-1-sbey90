import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Reimbursement;
import models.User;
import repositories.UserDAO;
import services.UserService;
import utils.HibernateUtil;
import web.RegistrationServlet;

public class Main {
	
	public static void main(String[] args) {
		
//SessionFactory sessionFactory = (SessionFactory) HibernateUtil.getSession();
//		
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		initialValues();
//		User user = new User();
//		user.getClass().toString();
//		
//		System.out.println("Fully qualified name is: " + user.getClass().toString());
		
//		RegistrationServlet register = new RegistrationServlet();
//		register.
		
		
		
		
	}
	
	public static void initialValues() {
		User u1 = new User("Aaron", "Boyd", "aboyd1", "pass123!", "aboyd@fake.com", "Employee");
		User u2 = new User("Cynthia", "Brian", "cbrian2", "myPass123!", "cbrian2@fake.com", "Employee");
		User u3 = new User("Bob", "Williams", "bwill5", "Emp123!", "bwill5@fake.com", "Employee");
		
		
//		UserService serve = new UserService();
//		
//		serve.insertUser(u1);
		
		UserService serve = new UserService();
		
//		serve.insert(u1);
//		serve.insert(u2);
//		serve.insert(u3);
		
		
	}

}
