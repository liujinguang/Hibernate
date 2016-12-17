package xyyj.chapter03;

import java.util.StringTokenizer;

public class Monkey {
	public Monkey() {

	}

	public Monkey(String firstname, String lastname, char gender, int age, String description) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender != 'F' || gender != 'M') {
			throw new IllegalArgumentException("Invalid Gender");
		}
		
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	/**
	 * This can only be visited by Hibernate
	 * @param age
	 */
	private void setAge(int age) {
		this.age = age;
	}

	public int getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(int avgAge) {
		this.avgAge = avgAge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return firstname + " " + lastname;
	}

	public void setName(String name) {
		StringTokenizer tokenizer = new StringTokenizer(name);
		firstname = tokenizer.nextToken();
		lastname = tokenizer.nextToken();
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "[ID=" + id +", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", age=" + age + ", avgAge=" + avgAge + ", description=" + description;
	}

	private Long id;
	private String firstname;
	private String lastname;
	private char gender;
	private int age;
	private int avgAge;
	private String description;
}
