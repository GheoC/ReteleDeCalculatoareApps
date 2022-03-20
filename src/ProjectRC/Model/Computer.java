package Model;

public class Computer
{

    private String ipAddress;
    private String buffer;
    private Computer nextPC;

    public Computer(String ipAddress, String buffer) {
        this.ipAddress = ipAddress;
        this.buffer = buffer;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public Computer getNextPC() {
        return nextPC;
    }

    public void setNextPC(Computer nextPC) {
        this.nextPC = nextPC;
    }

    @Override
    public String toString() {
        return "Calculator {" +
                "ipAddress='" + ipAddress + '\'' +
                ", buffer='" + buffer + '\'' +
                '}';
    }
}
