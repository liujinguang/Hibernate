package xyyj.chapter08;

public class Computer {

    private long id;
    private String type;
    private CpuBox cpuBox;

    public Computer() {
    }

    public Computer(CpuBox cpuBox) {
        this.cpuBox = cpuBox;
    }

    public Computer(String type, CpuBox cpuBox) {
        this.type = type;
        this.cpuBox = cpuBox;
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

    public CpuBox getCpuBox() {
        return this.cpuBox;
    }

    public void setCpuBox(CpuBox cpuBox) {
        this.cpuBox = cpuBox;
    }
}
