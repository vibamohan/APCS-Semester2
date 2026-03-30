public abstract class Monster {
    private String name;
    private static int count = 0;
    private static int coins = 0;

    public Monster(String name) {
        this.name = name;
        count++;
    }

    public abstract String getFavFood();

    public String getName() {
        return "My name is " + name;
    }

    public static int getCount() {
        return count;
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public static int getCoins() {
        return coins;
    }

    public void getInfo() {
        System.out.println(getName());
        System.out.println("My favorite food is " + getFavFood() + ".");
    }
}
