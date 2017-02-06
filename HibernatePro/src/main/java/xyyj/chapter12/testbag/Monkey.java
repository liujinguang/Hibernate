package xyyj.chapter12.testbag;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
	public Monkey() {
	}

	public Monkey(List<String> images) {
		this.images = images;
	}

	public Monkey(String name, int age, List<String> images) {
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

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	private Long id;
	private String name;
	private int age;
	private List<String> images = new ArrayList<String>();
}
