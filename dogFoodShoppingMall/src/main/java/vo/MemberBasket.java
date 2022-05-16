package vo;

public class MemberBasket {
	private int productId;
	private String photoName;
	private String productName;
	private int gram;
	private int price;
	private int quantity;
	
	public MemberBasket () {}

	public MemberBasket(int productId, String photoName, String productName, int gram, int price, int quantity) {
		super();
		this.productId = productId;
		this.photoName = photoName;
		this.productName = productName;
		this.gram = gram;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getGram() {
		return gram;
	}

	public void setGram(int gram) {
		this.gram = gram;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "MemberBasket [productId=" + productId + ", photoName=" + photoName + ", productName=" + productName
				+ ", gram=" + gram + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
