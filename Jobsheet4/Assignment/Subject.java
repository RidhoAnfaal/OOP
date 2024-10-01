package Jobsheet4.Assignment;

public class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String info() {
        return "Subject: " + this.name;
    }
}
