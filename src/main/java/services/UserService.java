package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import modelDTO.UserDTO;
import models.User;
import repositories.UserDAO;

public class UserService {

	private static Logger log = Logger.getLogger(UserService.class);

	public static void insert(User user) {

		UserDAO.insert(user);
		log.info("User has been inserted into the Database");
	}

	public static void update(User user) {
		UserDAO.update(user);
		log.info("User has been updated int the Database.");
	}

	public static List<User> selectAll() { // May need to check  -- likely will not work
		List<User> userList = new ArrayList<User>();

		log.info("Users have been returned from the Database.");
		return UserDAO.selectAll();
		
	}

	public static User selectByUsername(String username) {
		List<User> allUsers = new ArrayList<User>();

		for (User u : allUsers) {
			if (u.getUsername().equals(username)) {
				return u;
			}
			log.info("user has been returned from the Database.");
		}
		log.info("User is null.");
		return null;
		
	}

	public static User confirmLogin(String username, String password) {

		User user = selectByUsername(username);
		if (user == null) {
			return null;
		}

		if (user.getPassword().equals(password)) {
			log.info("User's login has been confirmed.");
			return user;
		}
		return null;
	}

	// Convert Method to convert users into DTO instances
	public static UserDTO convertUsers(User users) {

		return new UserDTO(users.getUserId(), users.getFirstName(), users.getLastName(), users.getUsername(),
				users.getPassword(), users.getEmail(), users.getRole());

	}


	// You may need a registration method that will attach to a registration .html form -- will also need a registration servlet 
	
	
}
