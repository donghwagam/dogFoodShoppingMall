package vo;

public class Brand {
	private int brandId;
	private String name;
	private String createDate;
	private String updateDate;
	
	public Brand() {}

	public Brand(int brandId, String name, String createDate, String updateDate) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
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
		return "Brand [brandId=" + brandId + ", name=" + name + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
