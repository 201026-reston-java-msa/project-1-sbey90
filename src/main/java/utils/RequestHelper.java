package utils;



import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.LoginTemplate;

public class RequestHelper {
	
	private static Logger log = Logger.getLogger(RequestHelper.class);
	
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		
		
		// LoginTemplate would be used here 
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		log.info("User is attempting to login with " + username);
		
		// Will need to create and call a UserService method to check if the username and password is correct.
	}

}
