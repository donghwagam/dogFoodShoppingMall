package vo;

public class Basket {
	private int productId;
	private String memberId;
	private int quantity;
	private String createDate;
	private String updateDate;
	
	public Basket() {}

	public Basket(int productId, String memberId, int quantity, String createDate, String updateDate) {
		super();
		this.productId = productId;
		this.memberId = memberId;
		this.quantity = quantity;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "Basket [productId=" + productId + ", memberId=" + memberId + ", quantity=" + quantity
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
