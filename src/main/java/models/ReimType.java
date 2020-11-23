package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reim_type")

public class ReimType {
	
	private static final long serialUID = 1l;
	
	
		@Id
		@Column(name="type_id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int typeId;
		
		@Column(name="reim_type")
		private String reimType;
		
		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		List<Reimbursement> reimbursements;
		
		
		
		public ReimType() {
			super();
		}

		public ReimType(int typeId, String reimType) {
			super();
			this.typeId = typeId;
			this.reimType = reimType;
		}

		public ReimType(String reimType) {
			super();
			this.reimType = reimType;
		}

		public int getTypeId() {
			return typeId;
		}

		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}

		public String getReimType() {
			return reimType;
		}

		public void setReimType(String reimType) {
			this.reimType = reimType;
		}

		@Override
		public String toString() {
			return "ReimType [typeId=" + typeId + ", reimType=" + reimType + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((reimType == null) ? 0 : reimType.hashCode());
			result = prime * result + typeId;
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
			ReimType other = (ReimType) obj;
			if (reimType == null) {
				if (other.reimType != null)
					return false;
			} else if (!reimType.equals(other.reimType))
				return false;
			if (typeId != other.typeId)
				return false;
			return true;
		}
		
		

}
