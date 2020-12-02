package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import modelDTO.ReimbursementDTO;
import models.Reimbursement;

/**
 * Servlet implementation class ReimAdjustServlet
 */

/*
 * Ideally I would like for this servelt to handle all reimbursement requests and responses.
 * 
 * This will also test if the JS script displays the content -- if not, first think will be to place that identifier on a completely empty div
 * 
 */
public class ReimAdjustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private static ObjectMapper om = new ObjectMapper();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // What are you getting
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		List<ReimbursementDTO> allDTO = new ArrayList<ReimbursementDTO>();
		
		for(Reimbursement r : all ) {
			
			allDTO.add(new ReimbursementDTO(r.getAuthor(),
					r.getResolver(),
					r.getType(),
					r.getStatus(),
					r.getAmount(),
					r.getDescrip(),
					r.getTime().toString()));
					
			
			
		}
		
		String json = om.writeValueAsString(allDTO);
		PrintWriter pw = response.getWriter();
		pw.println(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
