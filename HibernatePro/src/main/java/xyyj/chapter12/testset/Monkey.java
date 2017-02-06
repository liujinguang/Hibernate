package xyyj.chapter12.testset;

import java.util.Set;
import java.util.TreeSet;

public class Monkey {

	public Monkey() {
	}

	public Monkey(Set<String> images) {
		this.images = images;
	}

	public Monkey(String name, int age, Set<String> images) {
		this.name = name;
		this.age = age;
		this.images = images;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "ID=" + id + ", name=" + name + ", age=" + age;
	}

	private Long id;
	private String name;
	private int age;
	private Set<String> images = new TreeSet<String>();
}
