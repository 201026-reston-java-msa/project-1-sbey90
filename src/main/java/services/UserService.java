package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import modelDTO.UserDTO;
import models.User;
import repositories.UserDAO;

public class UserService extends UserDAO {  // added extends

	private static Logger log = Logger.getLogger(UserService.class);

	public static User insertUser(User user) {  

		try {
			log.info("Attempting to insert a user into the Database.");

			insert(user);

			log.info("Successfully inserted new user into the Database!");
			return user;
		} catch (HibernateException e) {
			log.warn("Unable to insert a user into the Database.", e);
			return null;
		}
	}

	public static void updateUser(User user, int id) {

		try {
			log.info("Attempting to locate the user by id in the Database.");
			UserDAO.selectById(id);

			log.info("Attempting to update the user in the Database.");
			UserDAO.update(user);

			log.info("Successfully updated the user in the Database!");
		} catch (HibernateException e) {
			log.warn("Unable to update user in the Database.", e);
		}
	}

	public List<User> selectAllUsers() {
		List<User> userList = new ArrayList<User>();

		try {
			log.info("Attempting to retrieve a list of users from the Database.");
			userList = UserDAO.selectAll();

			log.info("Successfully retrieved a list of users from the Database!");
			return userList;
		} catch (HibernateException e) {
			log.warn("Unable to retrieve a list of users from the Database.", e);
		}
		return null;
	}

	public static User selectByUsername(String username) {
		List<User> allUsers = new ArrayList<User>();

		for (User u : allUsers) {
			if (u.getUsername().equals(username)) {
				return u;
			}
			log.info("User has been returned from the Database.");
			log.info("User is null.");
			
		}
		
		return null;

	}

	public static UserDTO confirmLogin(String username, String password) {
	
		if(username == null || password == null) {
			return null;
		}
		
		User user = selectByUsername(username);
		UserDTO dto = new UserDTO();
		
		if(user != null) {
			
			dto = convertUsers(user);
			return dto;
		} 
		return dto;
		
	}

	// Convert Method to convert users into DTO instances
	public static UserDTO convertUsers(User users) {

		return new UserDTO(users.getUserId(), users.getFirstName(), users.getLastName(), users.getUsername(),
				users.getPassword(), users.getEmail(), users.getRole());

	}

	
	public static User convertFromDTO(UserDTO uDTO) {
		
		return new User(uDTO.getUserId(), uDTO.getFirstName(), uDTO.getLastName(), uDTO.getUsername(), uDTO.getPassword(),
				uDTO.getEmail(), uDTO.getRole());
	}

	

}
