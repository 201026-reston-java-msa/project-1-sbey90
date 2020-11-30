package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import models.User;
import services.UserService;
import utils.HTMLTemplate;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(RegistrationServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		
		log.info("Attempting to insert user information");
		
		User u = new User(firstName, lastName, username, password, email, role);
 
		u = UserService.insertUser(u);  // CHECK - tried to move between lines 55 & 56 - wanted a SupressWarnings tag
		
		if(u != null) {
			HttpSession session = request.getSession();  // This sets the attributes of the user's session 
			session.setAttribute("firstName", firstName); 
			session.setAttribute("lastName", lastName);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("email", email);
			session.setAttribute("userRole", role);
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			log.info("User is successfully registered"+ firstName +" "+ lastName +" "+ username +" "+ password +" " + email + " "+ role);
			
			
		} else {
			PrintWriter pw = HTMLTemplate.getHtmlWriter(response);
			log.info("User cannot be registered to the Database.");
			pw.println("<h1 style='color: red;'> 500 Error </h1>");
		}
				
	
	}

}
