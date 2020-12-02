package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import models.ReimStatus;
import models.ReimType;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import utils.HTMLTemplate;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ProfileServlet.class);
	
	private static LocalDateTime time = LocalDateTime.now();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User author = (User)request.getAttribute("author");
		User resolver = (User)request.getAttribute("resolver");
		ReimType type = (ReimType)request.getAttribute("type");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		log.info("parameters have been received");
		
		Reimbursement reim = new Reimbursement();
		
		Reimbursement r = new Reimbursement(author, resolver, type, reim.getStatus(), amount, description);
		ReimbursementService service = new ReimbursementService();
//		ReimStatus status = new ReimStatus();
		service.submitReimbursementRequest(r, "pending");
		
		if(r != null) {
			HttpSession session = request.getSession();
			session.setAttribute("author", author);
			session.setAttribute("resolver", resolver);
			session.setAttribute("type", type);
			session.setAttribute("amount", amount);
			session.setAttribute("description", description);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
			log.info("Successfully submitted reimbursement request.");
			
		} else {
			handleFailure(response);
		
		}
		
	}

	
	private void handleFailure(HttpServletResponse response) throws IOException {
		PrintWriter pw = HTMLTemplate.getHtmlWriter(response);
		log.info("User cannot be registered to the Database.");
		pw.println("<h1 style='color: red;'> 500 Error </h1>");
	}

}
