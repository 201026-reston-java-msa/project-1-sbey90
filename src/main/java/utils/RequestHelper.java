package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import modelDTO.ReimbursementDTO;
import modelDTO.UserDTO;
import models.LoginTemplate;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import services.UserService;

public class RequestHelper {

	private static Logger log = Logger.getLogger(RequestHelper.class);

	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {

		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = sb.toString();

		// LoginTemplate would be used here
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User is attempting to login with " + username);

		UserDTO u = UserService.confirmLogin(username, password);

		if (u != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);

			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			User user = new User();
			UserDTO uDTO = UserService.convertUsers(user);
			
				
			pw.println(om.writeValueAsString(uDTO));  //.. NOT CURRENTLY USING THIS CLASS

			log.info(username + " has successfully logged in.");
		} else {
			res.setContentType("application/json");
			res.setStatus(204);
			log.warn("unable to process request.");
		}

		// Will need to create and call a UserService method to check if the username
		// and password is correct.
	}

	public static void processUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");

		List<User> allUsers = new ArrayList<User>();
		List<UserDTO> allDTOUsers = new ArrayList<UserDTO>();

		for (User u : allUsers) {
			allDTOUsers.add(UserService.convertUsers(u));
		}
		String json = om.writeValueAsString(allDTOUsers);

		PrintWriter pw = res.getWriter();
		pw.println(json);
	}
	
	public static void processReimbursements(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		List<ReimbursementDTO> allDTOReims = new ArrayList<ReimbursementDTO>();
		
		for(Reimbursement r : reimList) {
			allDTOReims.add(ReimbursementService.convertToDTO(r));
		}
		
		String json = om.writeValueAsString(allDTOReims);
		
		PrintWriter pw = res.getWriter();
		pw.println(json);
	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out.");
			session.invalidate();
		}
		res.setStatus(200);
	}

}
