package vo;

public class MemberDogAllergy {
	private int memberDogId;
	private int allergyId;
	private String updateDate;
	
	public MemberDogAllergy() {}
	
	public MemberDogAllergy(int memberDogId, int allergyId, String updateDate) {
		super();
		this.memberDogId = memberDogId;
		this.allergyId = allergyId;
		this.updateDate = updateDate;
	}

	public int getMemberDogId() {
		return memberDogId;
	}

	public void setMemberDogId(int memberDogId) {
		this.memberDogId = memberDogId;
	}

	public int getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "MemberDogAllergy [memberDogId=" + memberDogId + ", allergyId=" + allergyId + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
}
