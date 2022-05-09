package vo;

public class Purchase {
	
	private int purchaseId;
	private String memberId;
	private String status;
	private String payment;
	private String totalPrice;
	private String createDate;
	private String updateDate;
	
	public Purchase() {
		super();
	}
	
	public Purchase(int purchaseId, String memberId, String status, String payment, String totalPrice, String createDate,
			String updateDate) {
		super();
		this.purchaseId = purchaseId;
		this.memberId = memberId;
		this.status = status;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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
		return "purchase [purchaseId=" + purchaseId + ", memberId=" + memberId + ", status=" + status + ", payment="
				+ payment + ", totalPrice=" + totalPrice + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	} 

}
