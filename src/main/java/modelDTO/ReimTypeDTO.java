package modelDTO;

import java.io.Serializable;

public class ReimTypeDTO implements Serializable{
	
	private int typeId;
	
	
	private String reimType;
	
	public ReimTypeDTO() {
		super();
	}

	public ReimTypeDTO(int typeId, String reimType) {
		super();
		this.typeId = typeId;
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
		return "ReimTypeDTO [typeId=" + typeId + ", reimType=" + reimType + "]";
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
		ReimTypeDTO other = (ReimTypeDTO) obj;
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
