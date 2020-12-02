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

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(LogoutServlet.class);
       
 
    public LogoutServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session != null) {

		
			RequestDispatcher rd = request.getRequestDispatcher("logout.html");
			rd.forward(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.println("<h3 style= 'color:red'> 500 Error </h3>");
			
		}
		
		log.info("Completed logout");
	}


}
