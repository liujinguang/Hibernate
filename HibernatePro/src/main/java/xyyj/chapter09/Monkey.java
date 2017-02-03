package xyyj.chapter09;

public class Monkey {
	public Monkey() {

	}

	public Monkey(String name, Address homeAddress, Address comAddress, Integer phone) {
		super();
		this.name = name;
		this.homeAddress = homeAddress;
		this.comAddress = comAddress;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getComAddress() {
		return comAddress;
	}

	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	private Long id;
	private String name;
	private Address homeAddress;
	private Address comAddress;
	private Integer phone;
}
