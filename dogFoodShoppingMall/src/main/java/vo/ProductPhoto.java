package vo;

public class ProductPhoto {
	
	
	private int photoId;
	private String originalName;
	private String name;
	private String type;
	private int volume;
	private int productId;
	private String createDate;
	private String updateDate;
	
	public ProductPhoto() {}
	
	public ProductPhoto(int photoId, String originalName, String name, String type, int volume,
			int productId, String createDate, String updateDate) {
		super();
		this.photoId = photoId;
		this.originalName = originalName;
		this.name = name;
		this.type = type;
		this.volume = volume;
		this.productId = productId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
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
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "productPhoto [photoId=" + photoId + ", originalName=" + originalName + ", name=" + name + ", type=" + type + ", volume=" + volume + ", productId=" + productId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
