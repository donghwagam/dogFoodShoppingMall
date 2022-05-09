package vo;

public class Qna {
	private int qnaId;
	private String title;
	private String memo;
	private String qnaKind;
	private String memberId;
	private int productId;
	private String createDate;
	
	public Qna() {}

	public Qna(int qnaId, String title, String memo, String qnaKind, String memberId, int productId,
			String createDate) {
		super();
		this.qnaId = qnaId;
		this.title = title;
		this.memo = memo;
		this.qnaKind = qnaKind;
		this.memberId = memberId;
		this.productId = productId;
		this.createDate = createDate;
	}
	
	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getQnaKind() {
		return qnaKind;
	}

	public void setQnaKind(String qnaKind) {
		this.qnaKind = qnaKind;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "qna [qnaId=" + qnaId + ", title=" + title + ", memo=" + memo + ", qnaKind=" + qnaKind + ", memberId="
				+ memberId + ", productId=" + productId + ", createDate=" + createDate + "]";
	}
	
	
}
