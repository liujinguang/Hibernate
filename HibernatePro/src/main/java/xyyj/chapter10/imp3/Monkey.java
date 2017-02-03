package xyyj.chapter10.imp3;

public class Monkey {

	public Monkey(String name, Team team) {
		this.name = name;
		this.team = team;
	}

	public Monkey() {

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
		// TODO Auto-generated method stub
		return "id=" + id + ", name=" + name;
	}

	private Long id;
	private String name;
	private Team team;
}
