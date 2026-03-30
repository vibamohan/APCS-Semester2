public class SmallDog extends Dog {
    public SmallDog(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return super.speak() + "....";
    }
}
