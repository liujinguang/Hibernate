package xyyj.chapter13.smm;

public class Teacher {
	private Long id;
	private String name;

	/** full constructor */
	public Teacher(String name) {
		this.name = name;
	}

	/** default constructor */
	public Teacher() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
