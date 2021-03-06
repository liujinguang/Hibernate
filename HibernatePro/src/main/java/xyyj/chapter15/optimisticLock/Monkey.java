package xyyj.chapter15.optimisticLock;

public class Monkey {

	private Long id;

	private String name;

	private int count;

	private int version;

	public Monkey(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public Monkey() {
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

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
