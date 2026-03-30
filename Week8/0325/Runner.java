import java.awt.*;
import javax.swing.*;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void speak() {
        System.out.println("Hello, my name is " + name);
    }

    public void drawMe(Graphics g, int x, int y) {
        g.drawRect(x, y, 100, 60);
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("woof");
    }

    public void printInfo() {
        super.speak();
        System.out.println("Name: " + super.getName());
        System.out.print("I make the sound ");
        this.speak();
    }

    @Override
    public void drawMe(Graphics g, int x, int y) {
        super.drawMe(g, x, y);

        g.drawOval(x + 20, y - 40, 60, 60);

        g.drawLine(x, y + 30, x - 20, y);
    }
}

class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("tweet");
    }

    public void printInfo() {
        super.speak();
        System.out.println("Name: " + super.getName());
        System.out.print("I make the sound ");
        this.speak();
    }

    @Override
    public void drawMe(Graphics g, int x, int y) {
        super.drawMe(g, x, y);

        g.drawOval(x + 10, y + 10, 80, 40);

        g.drawLine(x + 100, y + 30, x + 130, y + 20);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("meow");
    }

    public void printInfo() {
        super.speak();
        System.out.println("Name: " + super.getName());
        System.out.print("I make the sound ");
        this.speak();
    }

    @Override
    public void drawMe(Graphics g, int x, int y) {
        super.drawMe(g, x, y);
        g.drawOval(x + 20, y - 40, 60, 60);
        g.drawLine(x + 30, y - 10, x, y - 20);
        g.drawLine(x + 70, y - 10, x + 100, y - 20);
        g.drawLine(x + 30, y - 40, x + 40, y - 60);
        g.drawLine(x + 60, y - 40, x + 50, y - 60);
    }
}

class Screen extends JPanel {
    private Dog dog;
    private Cat cat;
    private Bird bird;

    public Screen() {
        dog = new Dog("Fido");
        cat = new Cat("Felix");
        bird = new Bird("Tweety");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dog.drawMe(g, 50, 150);
        cat.drawMe(g, 250, 150);
        bird.drawMe(g, 450, 150);
        g.drawString(dog.getName(), 50, 120);
        g.drawString(cat.getName(), 250, 120);
        g.drawString(bird.getName(), 450, 120);
    }
}

public class Runner {
    public static void main(String[] args) {
        Animal a = new Animal("blank");
        a.speak();

        Dog d = new Dog("Fido");
        d.printInfo();

        Bird b = new Bird("Tweety");
        b.printInfo();

        JFrame frame = new JFrame("Animal Drawing");
        Screen screen = new Screen();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.add(screen);
        frame.setVisible(true);
    }
}
