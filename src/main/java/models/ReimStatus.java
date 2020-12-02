package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reim_status")  //Testing as Hibernate is recreating the same tables
public class ReimStatus {
	
	private static final long serialUID = 1L;
	
	
//	@Id
//	@JoinColumn(name="reim_id_FK", insertable=false, updatable=false)
//	private int reimId;
	
	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusId;
	
	@Column(name="status")
	private String status;
	
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	List<Reimbursement> reimbursements;
	
	
	
	public ReimStatus() {
		super();
	}

	public ReimStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public ReimStatus(String status) {
		super();
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimStatus [statusId=" + statusId + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimStatus other = (ReimStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		return true;
	}
	
	

}
