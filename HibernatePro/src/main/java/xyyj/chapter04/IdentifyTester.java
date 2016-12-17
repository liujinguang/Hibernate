package xyyj.chapter04;

public class IdentifyTester {
	public IdentifyTester(String name) {
		this.name = name;
	}

	public IdentifyTester() {
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

	private Long id;
	private String name;
}
