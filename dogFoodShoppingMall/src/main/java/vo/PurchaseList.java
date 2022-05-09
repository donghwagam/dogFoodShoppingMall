package vo;

public class PurchaseList {

	private int purchaseId;
	private int productId;
	private int quantity;
	private String updateDate;
	
	
	public PurchaseList() {

	}
	
	
	public PurchaseList(int purchaseId, int productId, int quantity, String updateDate) {
		super();
		this.purchaseId = purchaseId;
		this.productId = productId;
		this.quantity = quantity;
		this.updateDate = updateDate;
	}
	
	
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "purchaseList [purchaseId=" + purchaseId + ", productId=" + productId + ", quantity=" + quantity
				+ ", updateDate=" + updateDate + "]";
	}

}
