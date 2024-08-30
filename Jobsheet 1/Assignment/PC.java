package Assignment;

public class PC extends ElectronicDevice {
    String procType;
    int ram;

    public PC(String brand, String model, String procType, int ram) {
        super(brand, model);
        this.procType = procType;
        this.ram = ram;
    }

    public void start() {
        System.out.println("Pc is starting up...");
    }

    public void shutDown() {
        System.out.println("Pc is shutting down...");
    }

    public void deviceInfo() {
        super.deviceInfo();
        System.out.println("Processor Type: " + procType + ", RAM Size: " + ram + "GB");
    }
}
