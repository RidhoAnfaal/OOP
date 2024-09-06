package Assignment;

public class Laptop extends ElectronicDevice {
    String procType;
    int batteryLife, ram;
    double weight;

    public Laptop(String brand, String procType, int ram, String model, int batteryLife, double weight) {
        super(brand, model);
        this.procType = procType;
        this.ram = ram;
        this.batteryLife = batteryLife;
        this.weight = weight;
    }

    public void start() {
        System.out.println("Laptop is starting up...");
    }

    public void shutDown() {
        System.out.println("Laptop is shutting down...");
    }

    public void deviceInfo() {
        super.deviceInfo();
        System.out.println(
                "Processor: " + procType + "  RAM size: " + ram + " Battery Life: " + batteryLife + " hours, Weight: "
                        + weight + " kg");
    }
}
