package xyyj.chapter07;

public class Monkey{

    private Long id;
    private String name;
    private Team team;

    public Monkey(String name, Team team) {
        this.name = name;
        this.team = team;
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

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    @Override
    public String toString() {
        return "[ID=" + id + ", name=" + name + "]";
    }
}

