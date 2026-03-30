import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Dog d1 = new Dog("Fido");
        System.out.println(d1.speak());
        try {
            BigDog d2 = (BigDog) d1;
            System.out.println(d2.speak());
        } catch (ClassCastException e) {
            System.out.println("Casting d1 to BigDog does not work because d1 was created as a Dog, not a BigDog.");
        }

        BigDog bd1 = new BigDog("Biggy");
        System.out.println(bd1.speak());
        Dog bd2 = bd1;
        System.out.println(bd2.speak());

        Husky h1 = new Husky("Snow");
        System.out.println(h1.speak());
        Dog h2 = h1;
        System.out.println(h2.speak());
        Husky h3 = (Husky) h2;
        System.out.println(h3.speak());
        BigDog h4 = h1;
        System.out.println(h4.speak());
        System.out.println("Casting h1 to BigDog works because Husky extends BigDog.");

        SmallDog sm = new SmallDog("Tiny");
        System.out.println(sm.speak());
        Dog d3 = sm;
        System.out.println(d3.speak());
        try {
            BigDog bd3 = (BigDog) d3;
            System.out.println(bd3.speak());
        } catch (ClassCastException e) {
            System.out.println("Casting sm to BigDog does not work because SmallDog and BigDog are different branches of Dog.");
        }

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("Buddy"));
        dogs.add(new BigDog("Tank"));
        dogs.add(new Husky("Ghost"));
        dogs.add(new SmallDog("Peanut"));

        for (Dog dog : dogs) {
            System.out.println(dog.speak());
        }
    }
}
