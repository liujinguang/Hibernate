package xyyj.chapter10.imp1;

public class JMonkey extends Monkey {
	public JMonkey() {
	}
	
	public JMonkey(String name, String color, Team team) {
		super(name, team);
		
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID=" + getId() + ",name=" + getName() + ",color=" + color;
	}
	
	private String color;
}
