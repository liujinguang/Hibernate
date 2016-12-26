package xyyj.chapter07;

import java.util.Set;
import java.util.HashSet;

public class Team {

    private Long id;
    private String name;
    private Set<Monkey> monkeys = new HashSet<Monkey>();

    public Team(String name, Set<Monkey> monkeys) {
        this.name = name;
        this.monkeys = monkeys;
    }

    public Team() {
    }

    public Team(Set<Monkey> monkeys) {
        this.monkeys = monkeys;
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

    public Set<Monkey> getMonkeys() {
        return this.monkeys;
    }

    public void setMonkeys(Set<Monkey> monkeys) {
        this.monkeys = monkeys;
    }

    @Override
    public String toString() {
        return "[ID=" + id + ", name=" + name + "]";
    }
}
