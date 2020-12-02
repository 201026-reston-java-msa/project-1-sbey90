package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.RequestHelper;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   final String URI = request.getRequestURI().replace("/LoginServlet", "");
	   
	   switch(URI) {
	   
//	   case "index":
//		   // will call on requestHelper here - check errors 
//		   break;
	   case "registration":
		RequestHelper.processUsers(request, response); 
		   break;
		   
	   case "login":
		RequestHelper.processLogin(request, response);
		   break;
		   
	   case "empProfile":
			   RequestHelper.processReimbursements(request, response); 
			   break;
			   
	   case "logout":
		   RequestHelper.processLogout(request, response); 
		   break;
	   }
   }
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		final String URI = request.getRequestURI().replace("/", "");
//	}

}
