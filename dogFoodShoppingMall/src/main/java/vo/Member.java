package vo;

public class Member {
	private String memberId;
	private String memberPw;
	private String name;
	private String birth;
	private String phone;
	private String email;
	private String gender;
	private String level;
	private String active;
	private int addressId;
	private String detailAddr;
	private String createDate;
	private String updateDate;
	
	public Member() {}

	public Member(String memberId, String memberPw, String name, String birth, String phone, String email,
			String gender, String level, String active, int addressId, String detailAddr, String createDate,
			String updateDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.level = level;
		this.active = active;
		this.addressId = addressId;
		this.detailAddr = detailAddr;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
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
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", birth=" + birth
				+ ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", level=" + level + ", active="
				+ active + ", addressId=" + addressId + ", detailAddr=" + detailAddr + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}
