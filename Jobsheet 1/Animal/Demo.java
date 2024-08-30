package Animal;

public class Demo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        dog.animalInfo("Dog", "Gold retriever", 4, 26);
        dog.eat();
        dog.makeSound();
        System.out.println("");

        cat.animalInfo("Cat", "Birman", 0, 0);
        cat.eat();
        cat.makeSound();
        System.out.println("");

        bird.eat();
        bird.makeSound();
        System.out.println("");
    }
}
