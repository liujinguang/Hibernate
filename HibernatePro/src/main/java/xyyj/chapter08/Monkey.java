package xyyj.chapter08;

public class Monkey {

    public Monkey() {
        // TODO Auto-generated constructor stub
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getComAddress() {
        return comAddress;
    }

    public void setComAddress(Address comAddress) {
        this.comAddress = comAddress;
    }

    private Long id;
    private String name;
    private Address homeAddress;
    private Address comAddress;
}
