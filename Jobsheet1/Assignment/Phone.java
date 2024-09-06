package Assignment;

public class Phone extends ElectronicDevice {
    double screenSize;
    String operatingSystem;

    public Phone(String brand, String model, double screenSize, String operatingSystem) {
        super(brand, model);
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
    }

    public void makeCall() {
        System.out.println("Making a call...");
    }

    public void receiveCall() {
        System.out.println("Receiving a call...");
    }

    public void deviceInfo() {
        super.deviceInfo();
        System.out.println("Screen size: " + screenSize + " inches, " + operatingSystem);
    }
}
