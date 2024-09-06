package Animal;

public class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }

    void animalInfo(String type, String breed, int age, double weight) {
        System.out.println("Type: " + type);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
    }

    void eat() {
        System.out.println("Eating");
    }
}
