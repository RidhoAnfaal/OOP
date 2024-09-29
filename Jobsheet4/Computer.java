package Jobsheet4;

public class Computer {
    private String brand;
    private Processor proc;

    public Computer() {

    }

    public Computer(String brand, Processor proc) {
        this.brand = brand;
        this.proc = proc;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setProc(Processor proc) {
        this.proc = proc;
    }

    public Processor getProc() {
        return this.proc;
    }

    public void info() {
        System.out.println("Computer Brand = " + brand);
        proc.info();
    }

}
