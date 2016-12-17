package xyyj.chapter05.unidirection;

public class Monkey {
	private long id;
	private String name;
	private Team team;

	public Monkey() {
	}

	public Monkey(String name, Team team) {
		this.name = name;
		this.team = team;
	}

	public long getId() {
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

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
