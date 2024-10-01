package Jobsheet4.Assignment;

public class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String info() {
        return "Teacher: " + this.name;
    }
}
