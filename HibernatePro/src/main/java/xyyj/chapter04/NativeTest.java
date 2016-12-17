package xyyj.chapter04;

public class NativeTest {
	public NativeTest(String name) {
		this.name = name;
	}

	public NativeTest() {
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
