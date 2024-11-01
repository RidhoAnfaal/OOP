package Jobsheet9.interfacetraining;

public class Udergraduated extends Student implements ICumlaude, IAchievers {
    public Udergraduated(String name) {
        super(name);
    }

    @Override
    public void graduate() {
        System.out.println("I have finished the thesis for Undergraduate");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3.51");
    }

    @Override
    public void winTheCompetition() {
        System.out.println("I have won an INTERNATIONAL competition");
    }

    @Override
    public void publishTheJournal() {
        System.out.println("I publish articles in INTERNATIONAL journals");
    }
}
