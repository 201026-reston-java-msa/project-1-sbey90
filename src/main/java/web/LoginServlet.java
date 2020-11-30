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

//import com.revature.util.HTMLTemplate;

import jdk.internal.org.jline.utils.Log;
import models.User;
import services.UserService;
import utils.HTMLTemplate;

//Home / Resources / HTTP Methods
//HTTP Methods
//REST APIs enable you to develop any kind of web application having all possible CRUD (create, retrieve, update, delete) operations. 
//REST guidelines suggest using a specific HTTP method on a particular type of call made to the server 
//(though technically it is possible to violate this guideline, yet it is highly discouraged).

//Use below-given information to find a suitable HTTP method for the action performed by API.
//
//Table of Contents
//
//HTTP GET
//HTTP POST
//HTTP PUT
//HTTP DELETE
//HTTP PATCH
//Summary
//Glossary
//
//HTTP GET
//Use GET requests to retrieve resource representation/information only – and not to modify it in any way. 
//As GET requests do not change the state of the resource, these are said to be safe methods.



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(LoginServlet.class);
       
    
    public LoginServlet() {
        super();
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Log.info("User attempted to login in with:" + username);
		User u = UserService.confirmLogin(username, password);
		
		if(u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);  // Must set attribute here
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			
			rd.forward(request, response);
			Log.info(username + " has successfully logged in.");
		
		} 
		else {
			Log.warn(username + " is not on file.");
			PrintWriter pw = HTMLTemplate.getHtmlWriter(response); // producing the serialized version of our home.html page to the user
			log.info(username + "has failed to log in.");
			pw.println("<h3 style='color: red'>Denied</h3>");
			pw.println("<p>Username or password is incorrect</p>");
		}
		log.info("LoginServlet finished.");
	}

}
