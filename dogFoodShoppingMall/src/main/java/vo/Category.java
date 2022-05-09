package vo;

public class Category {
	private int categoryId;
	private String name;
	private String createDate;
	private String updateDate;
	
	public Category() {}

	public Category(int categoryId, String name, String createDate, String updateDate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Category [categoryId=" + categoryId + ", name=" + name + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
	
}
