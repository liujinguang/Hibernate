package xyyj.chapter02;

public class Monkey {
	public Monkey() {
	}
	
	public Monkey(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "[ID = " + id + ", name = " + name + ", age = " + age + ", gender = " + gender + "]";
	}
	
	private Long id;
	private String name;
	private int age;
	private char gender;

}
