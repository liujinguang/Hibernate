package xyyj.chapter12.testsort;

import java.util.Set;
import java.util.TreeSet;

public class Monkey {
	private Long id;
	private String name;
	private int age;
	private Set<String> images = new TreeSet<String>();

	/** full constructor */
	public Monkey(String name, int age, Set<String> images) {
		this.name = name;
		this.age = age;
		this.images = images;
	}

	/** default constructor */
	public Monkey() {
	}

	/** minimal constructor */
	public Monkey(Set<String> images) {
		this.images = images;
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

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<String> getImages() {
		return this.images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
}
