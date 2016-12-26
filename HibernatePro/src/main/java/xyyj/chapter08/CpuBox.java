package xyyj.chapter08;

public class CpuBox {

    private String type;
    private GraphicsCard graphicsCard;
    private Vendor vendor;
    private Computer computer;

    public CpuBox() {
    }

    public CpuBox(Vendor vendor) {
        this.vendor = vendor;
    }

    public CpuBox(String type, GraphicsCard graphicsCard, Vendor vendor,
            Computer computer) {
        this.type = type;
        this.graphicsCard = graphicsCard;
        this.vendor = vendor;
        this.computer = computer;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GraphicsCard getGraphicsCard() {
        return this.graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Computer getComputer() {
        return this.computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

}
