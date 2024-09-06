package Assignment;

public class Demo {
    public static void main(String[] args) {
        PC pc = new PC("MSI", "Mid-end PC", "Intel core i5 9400f", 16);
        Laptop laptop = new Laptop("MSI", "Intel core i9 13900H", 32, "KATANA 15", 2, 2.25);
        Phone phone = new Phone("VIVO", "Y17", 6.35, "Android");
        SmartTv smartv = new SmartTv("SHARP", "4T-C42FK1I", 50, "4K");

        pc.deviceInfo();
        pc.start();
        pc.shutDown();
        System.out.println("");

        laptop.deviceInfo();
        laptop.start();
        laptop.shutDown();
        System.out.println("");

        phone.deviceInfo();
        phone.makeCall();
        phone.receiveCall();
        System.out.println("");

        smartv.deviceInfo();
        smartv.turnOn();
        smartv.turnOff();
    }
}
