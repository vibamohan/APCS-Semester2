public class Runner {
    public static void main(String[] args) {
        Vampire vampire = new Vampire("Vlad");
        Mummy mummy = new Mummy("Tut");
        Witch witch = new Witch("Sabrina");

        vampire.getInfo();
        vampire.addCoins(12);
        System.out.println();

        mummy.getInfo();
        mummy.addCoins(7);
        System.out.println();

        witch.getInfo();
        witch.addCoins(15);
        System.out.println();

        System.out.println("Monster count: " + Monster.getCount());
        System.out.println("Group coins: " + Monster.getCoins());
    }
}
