package Jobsheet9.interfacetraining;

public class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public void studyInCampus() {
        System.out.println("I am a student, my name is " + this.name);
        System.out.println("I study in campus.");
    }
}
