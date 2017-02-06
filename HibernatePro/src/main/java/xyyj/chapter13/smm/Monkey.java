package xyyj.chapter13.smm;

import java.util.Set;
import java.util.HashSet;

public class Monkey {
	private Long id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public Monkey(String name, Set<Teacher> teachers) {
		this.name = name;
		this.teachers = teachers;
	}

	/** default constructor */
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

	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
