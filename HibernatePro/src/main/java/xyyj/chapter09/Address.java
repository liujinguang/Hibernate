package xyyj.chapter09;

public class Address {
	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public Address(String province, String city, String street, String zipcode) {
		this.province = province;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	@Override
	public int hashCode() {
		int result;

		result = province == null ? 0 : province.hashCode();
		result = 29 * result + (city == null ? 0 : city.hashCode());
		result = 29 * result + (street == null ? 0 : street.hashCode());
		result = 29 * result + (zipcode == null ? 0 : zipcode.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Address)) {
			return false;
		}

		final Address address = (Address) obj;

		if (!province.equals(address.province)) {
			return false;
		}
		if (!city.equals(address.city)) {
			return false;
		}
		if (!street.equals(address.street)) {
			return false;
		}
		if (!zipcode.equals(address.zipcode)) {
			return false;
		}

		return true;
	}

	private final String province;
	private final String city;
	private final String street;

	private final String zipcode;
}
