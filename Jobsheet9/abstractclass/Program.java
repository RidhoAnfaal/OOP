package Jobsheet9.abstractclass;

public class Program {
    public static void main(String[] args) {
        Cat asiCat = new Cat();
        Fish dolphin = new Fish();

        People john = new People("John");
        People ben = new People("Ben");

        john.setPet(asiCat);
        ben.setPet(dolphin);

        john.takePetToWalk();
        ben.takePetToWalk();
    }
}
