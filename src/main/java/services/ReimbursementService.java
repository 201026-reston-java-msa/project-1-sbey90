package services;

import java.util.ArrayList;
import java.util.List;

import modelDTO.ReimbursementDTO;
import models.Reimbursement;
import repositories.ReimbursementDAO;

public class ReimbursementService {

	public static void insert(Reimbursement r) {
		ReimbursementDAO.insert(r);

	}

	public static void update(Reimbursement r) {
		ReimbursementDAO.update(r);
	}

	public static List<Reimbursement> selectAll() {
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();

		return ReimbursementDAO.selectAll();
	}

	public static Reimbursement selectById(int id) {
		return ReimbursementDAO.selectyById(id);
	}

	public static void delete(Reimbursement r) {
		ReimbursementDAO.delete(r);
	}

	public ReimbursementDTO convertToDTO(Reimbursement r) {

		List<Reimbursement> allReims = new ArrayList<Reimbursement>();

		return new ReimbursementDTO(r.getReimb_id(), r.getAuthor(), r.getResolver(), r.isStatus(), r.getDescrip(),
				r.getAmount(), r.getTimeStamp().toString());

	}

	// Will need to include a search fields within the Reimbursement html page/
	// Manager html page to search for reimbursements

}
