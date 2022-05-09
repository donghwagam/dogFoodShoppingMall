package vo;

public class ReviewPhoto {
	private int reviewPhotoId;
	private String originalName;
	private String name;
	private String reviewPhoto;
	private String type;
	private int volume;
	private int reviewId;
	
	public ReviewPhoto() {}

	public ReviewPhoto(int reviewPhotoId, String originalName, String name, String reviewPhoto, String type, int volume,
			int reviewId) {
		super();
		this.reviewPhotoId = reviewPhotoId;
		this.originalName = originalName;
		this.name = name;
		this.reviewPhoto = reviewPhoto;
		this.type = type;
		this.volume = volume;
		this.reviewId = reviewId;
	}

	public int getReviewPhotoId() {
		return reviewPhotoId;
	}

	public void setReviewPhotoId(int reviewPhotoId) {
		this.reviewPhotoId = reviewPhotoId;
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

	public String getReviewPhoto() {
		return reviewPhoto;
	}

	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
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

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "ReviewPhoto [reviewPhotoId=" + reviewPhotoId + ", originalName=" + originalName + ", name=" + name
				+ ", reviewPhoto=" + reviewPhoto + ", type=" + type + ", volume=" + volume + ", reviewId=" + reviewId
				+ "]";
	}
}
