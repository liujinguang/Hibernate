package xyyj.chapter08;

public class Vendor {

    private Long id;
    private String type;

    public Vendor() {
    }

    public Vendor(String type) {
        this.type = type;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
