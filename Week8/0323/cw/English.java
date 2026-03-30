
public class English implements Language {

    private String name;

    public English() {
        this.name = "Viba";
    }

    @Override
    public String getAuthor() {
        return author + " " + name;
    }

    @Override
    public String getHello() {
        return "Hello";
    }

    @Override
    public String getBye() {
        return "Goodbye";
    }

    @Override
    public String getThankYou() {
        return "Thank you";
    }
}
