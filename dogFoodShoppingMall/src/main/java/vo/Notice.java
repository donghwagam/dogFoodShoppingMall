package vo;

public class Notice {
	private int noticeId;
	private String memberId;
	private String title;
	private String noticeContent;
	private String createDate;
	private String updateDate;
	
	public Notice() {}
	
	public Notice(int noticeId, String memberId, String title, String noticeContent, String createDate,
			String updateDate) {
		super();
		this.noticeId = noticeId;
		this.memberId = memberId;
		this.title = title;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
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
		return "Notice [noticeId=" + noticeId + ", memberId=" + memberId + ", title=" + title + ", noticeContent="
				+ noticeContent + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
