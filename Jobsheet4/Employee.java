package Jobsheet4;

public class Employee {
    private String identityNumber;
    private String name;

    public Employee(String identityNumber, String name) {
        this.identityNumber = identityNumber;
        this.name = name;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String info() {
        String info = "";
        info += "Identity Number: " + this.identityNumber + "\n";
        info += "Name: " + this.name + "\n";
        return info;
    }
}
