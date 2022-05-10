package vo;

public class MemberDog {
	private int memberDogId;
	private String memberId;
	private int dogId;
	private String birth;
	private int weight;
	private String createDate;
	private String updateDate;
	
	public MemberDog() {}
	
	public MemberDog(int memberDogId, String memberId, int dogId, String birth, int weight, String createDate,
			String updateDate) {
		super();
		this.memberDogId = memberDogId;
		this.memberId = memberId;
		this.dogId = dogId;
		this.birth = birth;
		this.weight = weight;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getMemberDogId() {
		return memberDogId;
	}

	public void setMemberDogId(int memberDogId) {
		this.memberDogId = memberDogId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
		return "MemberDog [memberDogId=" + memberDogId + ", memberId=" + memberId + ", dogId=" + dogId + ", birth="
				+ birth + ", weight=" + weight + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
}
