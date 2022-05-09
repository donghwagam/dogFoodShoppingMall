package vo;

public class Product {
	private int productId;
	private String name;
	private int price;
	private double gram;
	private String rate;
	private int feedSize;
	private String origin;
	private String info;
	private int stock;
	private int brandId;
	private String createDate;
	private String updateDate;
	
	public Product() {}

	public Product(int productId, String name, int price, double gram, String rate, int feedSize, String origin,
			String info, int stock, int brandId, String createDate, String updateDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.gram = gram;
		this.rate = rate;
		this.feedSize = feedSize;
		this.origin = origin;
		this.info = info;
		this.stock = stock;
		this.brandId = brandId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getGram() {
		return gram;
	}

	public void setGram(double gram) {
		this.gram = gram;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getFeedSize() {
		return feedSize;
	}

	public void setFeedSize(int feedSize) {
		this.feedSize = feedSize;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
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
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", gram=" + gram + ", rate="
				+ rate + ", feedSize=" + feedSize + ", origin=" + origin + ", info=" + info + ", stock=" + stock
				+ ", brandId=" + brandId + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
