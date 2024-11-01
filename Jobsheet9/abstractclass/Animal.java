package Jobsheet9.abstractclass;

public abstract class Animal {
    @SuppressWarnings("unused")
    private int age;

    protected Animal() {
        this.age = 0;
    }

    public void ageIncreased() {
        this.age += 1;
    }

    public abstract void move();
}
