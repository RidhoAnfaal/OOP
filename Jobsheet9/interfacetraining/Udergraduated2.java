package Jobsheet9.interfacetraining;

public class Udergraduated2 extends Student implements ICumlaude {
    public Udergraduated2(String name) {
        super(name);
    }

    @Override
    public void graduate() {
        System.out.println("I have finished the thesis for Undergraduate");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3.1");
    }
}
