package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import modelDTO.UserRolesDTO;
import models.User;
import models.UserRoles;
import repositories.UserRolesDAO;

public class UserRolesService {

	private static Logger log = Logger.getLogger(UserRolesService.class);

	public void insertManagerRole(User u, UserRoles role) {

		try {
			log.info("Attempting to insert Manager into the Database.");
			UserRolesDAO.insert(role);
			

			log.info("Successfully inserted Manager into the Database.");
		} catch (HibernateException e) {
			log.warn("Unable to insert Manager into the Database.", e);
		}
	}

	public void insertEmployeeRole(User u, UserRoles role) {

		try {
			log.info("Attempting to insert Employee into the Database.");
			UserRolesDAO.insert(role);
			

			log.info("Successfully inserted Employee into the Database.");
		} catch (HibernateException e) {
			log.warn("Unable to insert Employee into the Database.", e);
		}
	}

	public void updateUserRole(UserRoles role, int id) {

		try {
			log.info("Attempting to locate user role by id.");
			UserRolesDAO.selectById(id);
			
			log.info("Attempting to update the user role.");
			UserRolesDAO.update(role);

			log.info("Successfully updated the user role in the Database!");
		} catch (HibernateException e) {
			log.warn("Unable to update user role in the Database.", e);
		}
	}

	public List<UserRoles> selectAllUserRoles() {

		List<UserRoles> roleList = new ArrayList<UserRoles>();

		try {

			log.info("Attempting to retrieve all user roles from the Database.");
			roleList = UserRolesDAO.selectAll();

			log.info("Successfully retrieved list of user roles from the Database!");
			return roleList;

		} catch (HibernateException e) {
			log.warn("Unable to retrieve a list of user roles from the Database.", e);
		}
		return null;
	}

	public void selectUserRoleById(int id) {

		try {
			log.info("Attempting to retrieve user role by id.");
			UserRolesDAO.selectById(id);

			log.info("Successfully retrieved user role by id!");
		} catch (HibernateException e) {
			log.warn("Unable to retrieve role by id from the Database.", e);
		}

	}

	public UserRolesDTO convertToDTO(UserRoles role) {
		return new UserRolesDTO(role.getUserRoleId(), role.getUserRole());
	}

}
