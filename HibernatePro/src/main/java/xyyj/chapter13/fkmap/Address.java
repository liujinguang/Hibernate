package xyyj.chapter13.fkmap;

public class Address {
	private Long id;
	private String street;
	private String city;
	private String province;
	private String zipcode;
	private Monkey monkey;

	/** full constructor */
	public Address(String province, String city, String street, String zipcode, Monkey monkey) {
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
		this.monkey = monkey;
	}

	/** default constructor */
	public Address() {
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Monkey getMonkey() {
		return this.monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

}
