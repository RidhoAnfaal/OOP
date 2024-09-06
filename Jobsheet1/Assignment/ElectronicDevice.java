package Assignment;

public class ElectronicDevice {
    String brand, model;

    public ElectronicDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void deviceInfo() {
        System.out.println("Brand:" + brand + ", Model: " + model);
    }
}
