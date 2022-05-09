package vo;

public class Address {
	private int AddressId;
	private String zipCode;
	private String province;
	private String city;
	private String town;
	private String street;
	private String building1;
	private String building2;
	
	
	public Address() {}

	
	public Address(int addressId, String zipCode, String province, String city, String town, String street,
			String building1, String building2) {
		super();
		AddressId = addressId;
		this.zipCode = zipCode;
		this.province = province;
		this.city = city;
		this.town = town;
		this.street = street;
		this.building1 = building1;
		this.building2 = building2;
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


	public String getBuilding1() {
		return building1;
	}


	public void setBuilding1(String building1) {
		this.building1 = building1;
	}


	public String getBuilding2() {
		return building2;
	}


	public void setBuilding2(String building2) {
		this.building2 = building2;
	}


	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", zipCode=" + zipCode + ", province=" + province + ", city=" + city
				+ ", town=" + town + ", street=" + street + ", building1=" + building1 + ", building2=" + building2
				+ "]";
	}
	
}
