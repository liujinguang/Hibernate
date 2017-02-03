package xyyj.chapter10.imp3;

public class CMonkey extends Monkey {
	public CMonkey() {
	}

	public CMonkey(String name, double length, Team team) {
		super(name, team);
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "ID=" + getId() + ",name=" + getName() + ",length=" + length;
	}

	private Double length;
}
