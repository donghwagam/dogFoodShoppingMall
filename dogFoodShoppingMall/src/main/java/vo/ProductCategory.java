package vo;

public class ProductCategory {
	private int productId;
	private int categoryId;
	private String updateDate;
	
	public ProductCategory() {}

	public ProductCategory(int productId, int categoryId, String updateDate) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.updateDate = updateDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "ProductCategory [productId=" + productId + ", categoryId=" + categoryId + ", updateDate=" + updateDate
				+ "]";
	}
	
}
