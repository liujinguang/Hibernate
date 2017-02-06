package xyyj.chapter13.fkmap;

public class Monkey {

	private Long id;
	private String name;
	private Address homeAddress;
	private Address comAddress;

	public Monkey(String name, Address homeAddress, Address comAddress) {
		this.name = name;
		this.homeAddress = homeAddress;
		this.comAddress = comAddress;
	}

	/** default constructor */
	public Monkey() {
	}

	/** minimal constructor */
	public Monkey(Address homeAddress, Address comAddress) {
		this.homeAddress = homeAddress;
		this.comAddress = comAddress;
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

	public Address getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getComAddress() {
		return this.comAddress;
	}

	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}

}
