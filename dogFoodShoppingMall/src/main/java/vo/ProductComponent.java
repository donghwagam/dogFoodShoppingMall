package vo;

public class ProductComponent {
	private int productId;
	private int componentId;
	private String updateDate;
	
	public ProductComponent() {}

	public ProductComponent(int productId, int componentId, String updateDate) {
		super();
		this.productId = productId;
		this.componentId = componentId;
		this.updateDate = updateDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "ProductComponent [productId=" + productId + ", componentId=" + componentId + ", updateDate="
				+ updateDate + "]";
	}
	
}
