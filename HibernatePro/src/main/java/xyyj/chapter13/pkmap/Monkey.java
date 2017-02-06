package xyyj.chapter13.pkmap;

public class Monkey {

	private Long id;
	private String name;
	private Address address;

	public Monkey(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	/** default constructor */
	public Monkey() {
	}

	/** minimal constructor */
	public Monkey(Address address) {
		this.address = address;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
