package vo;

public class PurchaseAddress {
	private int purchaseId;
	private String purchaseName;
	private String purchasePhone;
	private String address;
	private String updateDate;
	
	public PurchaseAddress() {}

	public PurchaseAddress(int purchaseId, String purchaseName, String purchasePhone, String address,
			String updateDate) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseName = purchaseName;
		this.purchasePhone = purchasePhone;
		this.address = address;
		this.updateDate = updateDate;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public String getPurchasePhone() {
		return purchasePhone;
	}

	public void setPurchasePhone(String purchasePhone) {
		this.purchasePhone = purchasePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "PurchaseAddress [purchaseId=" + purchaseId + ", purchaseName=" + purchaseName + ", purchasePhone="
				+ purchasePhone + ", address=" + address + ", updateDate=" + updateDate + "]";
	}
	
}
