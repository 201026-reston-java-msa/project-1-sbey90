package modelDTO;

import java.io.Serializable;

public class ReimbursementDTO implements Serializable {

	private int reimb_id;
	private String author;
	private String resolver;
	private boolean status;
	private int amount;
	private String descrip;
	private String timeStamp;

	public ReimbursementDTO() {
		super();
	}

	public ReimbursementDTO(int reimb_id, String author, String resolver, boolean status, String timeStamp, int amount,
			String descrip) {
		super();
		this.reimb_id = reimb_id;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.timeStamp = timeStamp;
		this.amount = amount;
		this.descrip = descrip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		if (amount != other.amount)
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
		if (status != other.status)
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [reimb_id=" + reimb_id + ", author=" + author + ", resolver=" + resolver + ", status="
				+ status + ", timeStamp=" + timeStamp + "]";
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
