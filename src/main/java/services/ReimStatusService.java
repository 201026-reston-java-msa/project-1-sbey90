package services;

import java.util.List;

import models.ReimStatus;
import repositories.ReimStatusDAO;

public class ReimStatusService {

	public static void insert(ReimStatus status) {
		ReimStatusDAO.insert(status);
	}

	public static void update(ReimStatus status) {
		ReimStatusDAO.update(status);
	}

	public static List<ReimStatus> selectAll() {
		return ReimStatusDAO.selectAll();
	}

	public static ReimStatus selectById(int id) {

		return (ReimStatus) ReimStatusDAO.selectById(id); // check
	}

}
