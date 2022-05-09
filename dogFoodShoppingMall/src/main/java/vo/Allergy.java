package vo;

public class Allergy {
	private int allergyId;
	private String name;
	private String createDate;
	private String updateDate;
	
	public Allergy() {}

	public Allergy(int allergyId, String name, String createDate, String updateDate) {
		super();
		this.allergyId = allergyId;
		this.name = name;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Allergy [allergyId=" + allergyId + ", name=" + name + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
}
