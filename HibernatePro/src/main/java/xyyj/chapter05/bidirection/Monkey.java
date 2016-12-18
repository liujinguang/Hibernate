package xyyj.chapter05.bidirection;

public class Monkey {
	public Monkey() {
		
	}
	
	public Monkey(String name) {
		this.name = name;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "[ID=" + id + ", name=" + name + "]";
	}

	private Long id;
	private String name;
	private Team team;
}
