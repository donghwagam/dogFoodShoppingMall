package vo;

public class Dog {
	private int dogId;
	private String spiece;
	private String createDate;
	private String updateDate;
	
	public Dog() {}
	
	public Dog(int dogId, String spiece, String createDate, String updateDate) {
		super();
		this.dogId = dogId;
		this.spiece = spiece;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public String getSpiece() {
		return spiece;
	}

	public void setSpiece(String spiece) {
		this.spiece = spiece;
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
		return "Dog [dogId=" + dogId + ", spiece=" + spiece + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

	
	
}
