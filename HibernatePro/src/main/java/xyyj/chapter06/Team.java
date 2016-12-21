package xyyj.chapter06;

import java.util.HashSet;
import java.util.Set;

public class Team {

    public Team() {
        // TODO Auto-generated constructor stub
    }
    
    public Team(String name) {
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
    
    public Set<Monkey> getMonkeys() {
        return monkeys;
    }

    public void setMonkeys(Set<Monkey> monkeys) {
        this.monkeys = monkeys;
    }


    private Long id;
    private String name;
    private Set<Monkey> monkeys = new HashSet<Monkey>();
}
