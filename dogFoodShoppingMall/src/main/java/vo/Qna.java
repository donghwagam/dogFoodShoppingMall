package vo;

public class Qna {
	private int qnaId;
	private String qnaKind;
	private String memo;
	private String memberId;
	private int productId;
	private String createDate;
	
	public Qna() {}

	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}

	public String getQnaKind() {
		return qnaKind;
	}

	public void setQnaKind(String qnaKind) {
		this.qnaKind = qnaKind;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
		return "Qna [qnaId=" + qnaId + ", qnaKind=" + qnaKind + ", memo=" + memo + ", memberId=" + memberId
				+ ", productId=" + productId + ", createDate=" + createDate + "]";
	}

	public Qna(int qnaId, String qnaKind, String memo, String memberId, int productId, String createDate) {
		super();
		this.qnaId = qnaId;
		this.qnaKind = qnaKind;
		this.memo = memo;
		this.memberId = memberId;
		this.productId = productId;
		this.createDate = createDate;
	}

	
	
}
