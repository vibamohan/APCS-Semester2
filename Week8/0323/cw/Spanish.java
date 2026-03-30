
public class Spanish implements Language {

    private String name;

    public Spanish() {
        this.name = "Viba";
    }

    @Override
    public String getAuthor() {
        return author + " " + name;
    }

    @Override
    public String getHello() {
        return "Hola";
    }

    @Override
    public String getBye() {
        return "Adiós";
    }

    @Override
    public String getThankYou() {
        return "Gracias";
    }
}
