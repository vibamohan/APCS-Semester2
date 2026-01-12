
public class Split {

    private String email;

    public Split(String email) {
        this.email = email;
    }

    public String getName() {
        int atIndex = email.indexOf("@");
        return email.substring(0, atIndex);
    }

    public String getDomain() {
        int atIndex = email.indexOf("@");
        return email.substring(atIndex + 1);
    }

    public String getLastNameMVLA(String mvla) {
        String name = email.substring(0, email.indexOf("@"));
        int dotIndex = name.indexOf(".");
        return name.substring(dotIndex + 1);
    }

    public String toString() {
        return "address: " + email;
    }
}
