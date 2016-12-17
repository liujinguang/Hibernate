package xyyj.chapter04;

public class HiloTester {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HiloTester() {
	}

	public HiloTester(String name) {
		this.name = name;
	}
	
	private String name;
	private Long id;
}
