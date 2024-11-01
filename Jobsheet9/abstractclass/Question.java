package Jobsheet9.abstractclass;

abstract class Shape {
    public abstract void draw();
}

abstract class Circle extends Shape {
    public void display() {
        System.out.println("This is a Circle");
    }
}

class FilledCircle extends Circle {
    @Override
    public void draw() {
        System.out.println("Drawing a Filled Circle");
    }
}

public class Question {
    public static void main(String[] args) {
        FilledCircle fc = new FilledCircle();
        fc.display();
        fc.draw();
    }
}