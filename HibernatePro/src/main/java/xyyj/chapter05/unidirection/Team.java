package xyyj.chapter05.unidirection;

public class Team {
	private Long id;
	private String name;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[ID=" + id + ", name=" + name + "]";
	}

}
