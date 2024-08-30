package Assignment;

public class SmartTv extends ElectronicDevice {
    double screenSize;
    String resolution;

    public SmartTv(String brand, String model, double screenSize, String resolution) {
        super(brand, model);
        this.screenSize = screenSize;
        this.resolution = resolution;
    }

    public void turnOn() {
        System.out.println("Smart TV is turning on...");
    }

    public void turnOff() {
        System.out.println("Smart TV is turning off...");
    }

    public void deviceInfo() {
        super.deviceInfo();
        System.out.println("Screen size: " + screenSize + " inches, Resolution: " + resolution);
    }
}
