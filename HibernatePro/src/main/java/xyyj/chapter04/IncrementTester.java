package xyyj.chapter04;

public class IncrementTester {
	public IncrementTester() {
	}
	
	public IncrementTester(String name) {
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[ID=" + id + ", name=" + name + "]"; 
	}

	private Long id;
	private String name;
}
