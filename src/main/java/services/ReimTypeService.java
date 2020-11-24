package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import modelDTO.ReimTypeDTO;
import models.ReimType;
import repositories.ReimTypeDAO;

public class ReimTypeService {

	private static Logger log = Logger.getLogger(ReimTypeService.class);

	public void insertReimType(ReimType type) {

		try {
			log.info("Attempting to insert reimbursement type into the Database.");
			ReimTypeDAO.insert(type);

			log.info("Successfully inserted reimbursement type into the Database!");

		} catch (HibernateException e) {
			log.warn("Unable to insert reimbursement type into the Database.", e);
		}

	}

	public void updateReimType(ReimType type, int id) {

		try {
			log.info("Attempting to locate type by id.");
			ReimTypeDAO.selectById(id);

			log.info("Attempting to update reimbursement type in the Database.");
			ReimTypeDAO.update(type);

			log.info("Successfully updated the reimbursement type in the Database!");
		} catch (HibernateException e) {
			log.warn("Unable to update reimbursement type in the Database.");
		}
	}

	public List<ReimType> selectAllTypes() {
		List<ReimType> typeList = new ArrayList<ReimType>();

		try {
			log.info("Attempting to retrieve a list of reimbursement types from the Database.");
			typeList = ReimTypeDAO.selectAll();

			log.info("Successfully retrieved a list of reiumbursement types from the Database!");
			return typeList;
		} catch (HibernateException e) {
			log.warn("Unable to retrieve a list of reimbursement types from the Database.", e);
		}
		return null;
	}

	public void selectTypeById(int id) {

		try {
			log.info("Attempting to locate reimbursement type by id.");
			ReimTypeDAO.selectById(id);

			log.info("Successfully located reimbursement type by id!");
		} catch (HibernateException e) {
			log.warn("Unable to locate reimbursment type by id.", e);
		}
	}

	public ReimTypeDTO convertToDTO(ReimType type) {
		return new ReimTypeDTO(type.getTypeId(), type.getReimType());
	}
}
