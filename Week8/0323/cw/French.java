
public class French implements Language {

    private String name;

    public French() {
        this.name = "Viba";
    }

    @Override
    public String getAuthor() {
        return author + " " + name;
    }

    @Override
    public String getHello() {
        return "Bonjour";
    }

    @Override
    public String getBye() {
        return "Au revoir";
    }

    @Override
    public String getThankYou() {
        return "Merci";
    }
}
