package vo;

public class Review {
	private int reviewId;
	private int purchaseId;
	private String title;
	private String reviewContent;
	private int rate;
	private String createDate;
	
	public Review() {}

	public Review(int reviewId, int purchaseId, String title, String reviewContent, int rate, String createDate) {
		super();
		this.reviewId = reviewId;
		this.purchaseId = purchaseId;
		this.title = title;
		this.reviewContent = reviewContent;
		this.rate = rate;
		this.createDate = createDate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", purchaseId=" + purchaseId + ", title=" + title + ", reviewContent="
				+ reviewContent + ", rate=" + rate + ", createDate=" + createDate + "]";
	}
	
	
}
