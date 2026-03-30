import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat("Whiskers"));
        animals.add(new Dog("Rex"));
        animals.add(new Bird("Sunny"));

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
