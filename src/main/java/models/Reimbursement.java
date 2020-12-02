package models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

@Entity
@Table(name = "reimbursements")
public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "reim_id") // , insertable=false, updatable=false
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reimb_id;


	@ManyToOne(cascade = CascadeType.ALL) // ,targetEntity=User.class
	@JoinColumn(name = "author") // , nullable=false
	private User author;

	@ManyToOne(cascade = CascadeType.ALL) // ,targetEntity=User.class
	@JoinColumn(name = "resolver", insertable = false, updatable = false)
	private User resolver;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "type", insertable = false, updatable = false) // was type_id
	private ReimType type;



	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // OVER HERE
	@JoinColumn(name = "status", insertable = false, updatable = false)
	private ReimStatus status;

	@Column(name = "amount")
	private String amount;

	@Column(name = "description")
	private String descrip;

	@Column(name = "time")
	private LocalDateTime time;

	public Reimbursement(int reimb_id, User author, User resolver, ReimType type, ReimStatus status, String amount,
			String descrip, LocalDateTime time) {
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

	public Reimbursement(User author, User resolver, ReimType type, ReimStatus status, String amount, String descrip,
			LocalDateTime time) {
		super();
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.descrip = descrip;
		this.time = time;
	}

	public Reimbursement(User author, User resolver, ReimType type, ReimStatus status, String amount, String descrip) {
		super();
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.descrip = descrip;
		this.time = time;
	}

	public Reimbursement() {
		super();
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
		Reimbursement other = (Reimbursement) obj;
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

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", author=" + author + ", resolver=" + resolver + ", type="
				+ type + ", status=" + status + ", amount=" + amount + ", descrip=" + descrip + ", time=" + time + "]";
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTimeStamp(LocalDateTime time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
