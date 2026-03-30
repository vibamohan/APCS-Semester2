
public class Tamil implements Language {

    private String name;

    public Tamil() {
        this.name = "Viba";
    }

    @Override
    public String getAuthor() {
        return author + " " + name;
    }

    @Override
    public String getHello() {
        return "வணக்கம்";
    }

    @Override
    public String getBye() {
        return "பிரியாவிடை";
    }

    @Override
    public String getThankYou() {
        return "நன்றி";
    }
}
