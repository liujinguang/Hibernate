package xyyj.chapter08;

public class Address {

    public Address() {
        // TODO Auto-generated constructor stub
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    public Address(String province, String city, String street, String zipcode,
            Monkey monkey) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.monkey = monkey;
    }

    private String street;
    private String city;
    private String province;
    private String zipcode;
    private Monkey monkey;
}
