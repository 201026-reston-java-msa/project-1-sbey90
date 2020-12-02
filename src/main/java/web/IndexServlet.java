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

import jdk.internal.org.jline.utils.Log;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(IndexServlet.class);
       
  
    public IndexServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		if(session != null) {
			RequestDispatcher rd = request.getRequestDispatcher("registration.html");
			rd.forward(request, response);
			Log.info("redirecting to the registration page.");
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<h2 style='color: red>Unabe to complete request</h2>");
		}
		Log.info("IndexServlet is finished.");
	}

}
