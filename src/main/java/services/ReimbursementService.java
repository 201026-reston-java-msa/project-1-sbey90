package services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import modelDTO.ReimbursementDTO;
import models.ReimStatus;
import models.Reimbursement;
import repositories.ReimbursementDAO;

public class ReimbursementService extends ReimbursementDAO {
	
	private static Logger log = Logger.getLogger(ReimStatus.class);

	
	// Need to be able to submit a reimbursement  -- How to set status on pending request?
		public void submitReimbursementRequest(Reimbursement r, String status) {  //Didn't work
			
			try {
				log.info("Attempting to submit reimbursement");
				insert(r);
				status = "pending"; // should set status to pending upon insertion of the request
				
				log.info("Reimbursement has successfully been submitted.");
				
			} catch (HibernateException e) {
				log.warn("Unable to insert reimbursement into the Database.", e);
			}
			
		}

		
		// Should be able to use in order to update the status of a reimbursement, may need to separately handle that within the status class
		
		// In hind sight, this may need to only be used in order to show that the amount on a request has been paid and then update the status elsewhere
		public void updateReimbursement(Reimbursement r, int id) {
			
			try {
				log.info("Attempting to locate reimbursement by id from service layer.");
				ReimbursementDAO.selectyById(id);
				
				log.info("Id was obtained successfully - attempting to update the reimbursment from service layer.");
				ReimbursementDAO.update(r);
				
				log.info("Successfully updated the reimbursement in the Database!");
				
			} catch (HibernateException e) {
				log.warn("Unable to update reimbursement in the Database.", e);
			}
		}

		
		public List<Reimbursement> selectAllReimbursements() {
			List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
			
			try {
				log.info("Attempting to retrieve all reimbursemenets from the Database. - Service Layer");
				reimbursementList = ReimbursementDAO.selectAll();
				if(reimbursementList != null) {
					log.info("Obtained reimbursement list!");
					return reimbursementList;
				}
				
			} catch (HibernateException e) {
				log.warn("Unable to retrieve list of reimbursements.", e);
			}
			return null;
		}

		
		public Reimbursement findById(Reimbursement r, int id) {
			
			try {
				log.info("Attempting to locate reimbursement by id.");
				r = ReimbursementDAO.selectyById(id);
				
				log.info("Obtained reimbursement!");
				return r;
				
			} catch (HibernateException e) {
				log.warn("Unable to locate reimbursement by id - Service Layer", e);
				return null;
			}
		}
		
		public void deleteReimbursment(Reimbursement r) {
			
			try {
				log.info("Attempting to delete reimbursement from the Database.");
				ReimbursementDAO.delete(r);
				
				log.info("Successfully deleted the reimbursement from the Database.");
			} catch (HibernateException e) {
				log.warn("Unable to delete reimbursement from the Database.", e);
			}
		}

	public static ReimbursementDTO convertToDTO(Reimbursement r) {

		List<Reimbursement> allReims = new ArrayList<Reimbursement>();

		return new ReimbursementDTO(r.getAuthor(), r.getResolver(), r.getType(), r.getAmount(), 
									r.getDescrip(), r.getTime().toString());

	}
	
	/*
	 * public ReimbursementDTO convertToDTO(Reimbursement r) {

		List<Reimbursement> allReims = new ArrayList<Reimbursement>();

		return new ReimbursementDTO(r.getReimb_id(), r.getAuthor(), r.getResolver(), r.getType(), r.getStatus(), r.getDescrip(),
				r.getAmount(), r.getTimeStamp().toString());

	}
	 */

	// Will need to include a search fields within the Reimbursement html page/
	// Manager html page to search for reimbursements

}
