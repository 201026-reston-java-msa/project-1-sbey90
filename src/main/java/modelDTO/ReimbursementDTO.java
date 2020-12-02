package modelDTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.ReimStatus;
import models.ReimType;
import models.User;



public class ReimbursementDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	


	private int reimb_id;

	private User author;
	
	
	private User resolver;
	
	
	private ReimType type;
	
	
	private ReimStatus status;
	
	
	private String amount;
	
	
	private String descrip;
	
	
	private String time;
	
	
	
	public ReimbursementDTO() {
		super();
	}



	public ReimbursementDTO(int reimb_id, User author, User resolver, ReimType type, ReimStatus status, String amount,
			String descrip, String time) {
		super();
		this.reimb_id = reimb_id;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.descrip = descrip;
		this.time = time;
	}
	
	public ReimbursementDTO(User author, User resolver, ReimType type, ReimStatus status, String amount,
			String descrip, String time) {
		super();
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.descrip = descrip;
		this.time = time;
	}



	



	public ReimbursementDTO(User author, User resolver, ReimType type, String amount, String descrip,
			String time) {
		super();
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.amount = amount;
		this.descrip = descrip;
		this.time = time;
	}



	@Override
	public String toString() {
		return "ReimbursementDTO [reimb_id=" + reimb_id + ", author=" + author + ", resolver=" + resolver + ", type="
				+ type + ", status=" + status + ", amount=" + amount + ", descrip=" + descrip + ", time=" + time + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ReimbursementDTO other = (ReimbursementDTO) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	public int getReimb_id() {
		return reimb_id;
	}



	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}



	public User getAuthor() {
		return author;
	}



	public void setAuthor(User author) {
		this.author = author;
	}



	public User getResolver() {
		return resolver;
	}



	public void setResolver(User resolver) {
		this.resolver = resolver;
	}



	public ReimType getType() {
		return type;
	}



	public void setType(ReimType type) {
		this.type = type;
	}



	public ReimStatus getStatus() {
		return status;
	}



	public void setStatus(ReimStatus status) {
		this.status = status;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getDescrip() {
		return descrip;
	}



	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
	