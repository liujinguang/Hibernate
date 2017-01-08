package xyyj.chapter11;

public class Monkey implements Comparable<Monkey>{

    public Monkey() {
    }
    
    public Monkey(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Monkey)) {
            return false;
        }

        final Monkey other = (Monkey) obj;

        if (this.name.equals(other.getName()) && this.id == other.getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 29 * result + id;

        return result;
    }
    
    @Override
    public String toString() {
    	return name + " " + id;
    }
    
	public int compareTo(Monkey o) {
		if (this.name.compareTo(o.getName()) > 0) {
			return 1;
		}
		
		if (this.name.compareTo(o.getName()) < 0) {
			return -1;
		}
		
		if (this.id > o.getId()) {
			return 1;
		}
		
		if (this.id < o.getId()) {
			return -1;
		}
		
		return 0;
	}

    private int id;
    private String name;

}
