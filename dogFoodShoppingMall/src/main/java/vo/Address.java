package vo;

public class Address {
	private int AddressId;
	private String zipCode;
	private String province;
	private String city;
	private String town;
	private String street;
	
	public Address() {}

	public Address(int addressId, String zipCode, String province, String city, String town, String street) {
		super();
		AddressId = addressId;
		this.zipCode = zipCode;
		this.province = province;
		this.city = city;
		this.town = town;
		this.street = street;
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", zipCode=" + zipCode + ", province=" + province + ", city=" + city
				+ ", town=" + town + ", street=" + street + "]";
	}
	
}
