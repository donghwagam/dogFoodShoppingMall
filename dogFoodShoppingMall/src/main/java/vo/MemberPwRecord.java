package vo;

public class MemberPwRecord {
	private String memberId;
	private String pwRecord;
	private String updateDate;
	
	public MemberPwRecord() {};
	
	public MemberPwRecord(String memberId, String pwRecord, String updateDate) {
		super();
		this.memberId = memberId;
		this.pwRecord = pwRecord;
		this.updateDate = updateDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPwRecord() {
		return pwRecord;
	}

	public void setPwRecord(String pwRecord) {
		this.pwRecord = pwRecord;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "MemberPwRecord [memberId=" + memberId + ", pwRecord=" + pwRecord + ", updateDate=" + updateDate + "]";
	}
	
}
