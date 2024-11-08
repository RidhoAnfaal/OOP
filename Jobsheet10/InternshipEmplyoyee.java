package Jobsheet10;

public class InternshipEmplyoyee extends Employee {
    private int lenght;

    public InternshipEmplyoyee(String name, int lenght) {
        this.lenght = lenght;
        this.lenght = lenght;
    }

    public int getLeght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " + lenght + " month/s\n";
        return info;
    }
}
