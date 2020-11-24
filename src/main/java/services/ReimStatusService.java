package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import modelDTO.ReimStatusDTO;
import models.ReimStatus;
import models.Reimbursement;
import models.User;
import repositories.ReimStatusDAO;

public class ReimStatusService {

	private static Logger log = Logger.getLogger(ReimStatus.class);

	// Took out for now as reimbursement will automatically have a status set per
	// the Reimbursement Service, however keeping in comments just in case.

//	public static void insert(ReimStatus status) {
//		ReimStatusDAO.insert(status);
//	}
//	

	public void updateStatus(ReimStatus status, int id) {

		try {
			log.info("Attempting to locate reimbursement status by id.");
			ReimStatusDAO.selectById(id);
			
			log.info("Attempting to update the reimbursement status within the Database.");
			ReimStatusDAO.update(status); // wondering if this should be set to the status string instead

			log.info("Successfully updated the status!");
		} catch (HibernateException e) {
			log.warn("Unable to update reimbursement status.", e);
		}
	}

	public List<ReimStatus> selectAllStatuses() {

		List<ReimStatus> statusList = new ArrayList<ReimStatus>();

		try {
			log.info("Attempting to retrieve all statuses from the Database.");
			statusList = ReimStatusDAO.selectAll();

			log.info("Successfully retrieved all statuses from the Database.");
			return statusList;
		} catch (HibernateException e) {
			log.warn("Unable to retrieve list of statuses from the Database", e);
			return null;
		}
	}

	// Cast may cause issues -- if so make this method void
	public ReimStatus selectByStatusId(ReimStatus status, int id) {

		try {
			log.info("Attempting to retrieve by status id from the database.");
			status = (ReimStatus) ReimStatusDAO.selectById(id);

			if (status != null) {
				return status;
			}

		} catch (HibernateException e) {
			log.warn("Unable to retrieve by id status from the Database.", e);
		}
		return null;
	}

	public ReimStatusDTO convertToDTO(ReimStatus status) {
		return new ReimStatusDTO(status.getStatusId(), status.getStatus());
	}

}
