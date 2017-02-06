package xyyj.chapter12.testmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monkey {
	public Monkey() {
	}

	public Monkey(Map<String, String> images) {
		this.images = images;
	}

	public Monkey(String name, int age, Map<String, String> images) {
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

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	private Long id;
	private String name;
	private int age;
	private Map<String, String> images = new HashMap<String, String>();
}
