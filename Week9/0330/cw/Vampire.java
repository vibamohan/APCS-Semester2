public class Vampire extends Monster {
    public Vampire(String name) {
        super(name);
    }

    @Override
    public String getFavFood() {
        return "blood oranges";
    }
}
