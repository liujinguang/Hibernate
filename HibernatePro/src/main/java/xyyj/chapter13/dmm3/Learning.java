package xyyj.chapter13.dmm3;

public class Learning {
	private Long id;
	private Teacher teacher;
	private Monkey monkey;
	private String gongfu;

	public Learning(Teacher teacher, Monkey monkey, String gongfu) {
		this.teacher = teacher;
		this.monkey = monkey;
		this.gongfu = gongfu;
	}

	/** default constructor */
	public Learning() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGongfu() {
		return this.gongfu;
	}

	public void setGongfu(String gongfu) {
		this.gongfu = gongfu;
	}

	public Monkey getMonkey() {
		return this.monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
