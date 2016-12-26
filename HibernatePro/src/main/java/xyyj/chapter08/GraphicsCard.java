package xyyj.chapter08;

public class GraphicsCard {

    private String type;
    private CpuBox cpuBox;

    public GraphicsCard() {
    }

    public GraphicsCard(String type, CpuBox cpuBox) {
        this.type = type;
        this.cpuBox = cpuBox;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CpuBox getCpuBox() {
        return this.cpuBox;
    }

    public void setCpuBox(CpuBox cpuBox) {
        this.cpuBox = cpuBox;
    }
}
