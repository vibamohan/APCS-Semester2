
public class Contact {

    private final String firstName;
    private final String lastName;
    private final String email;

    public Contact(String f, String l, String e) {
        firstName = f;
        lastName = l;
        email = e;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return email.substring(0, email.indexOf("@"));
    }

    public String getDomainName() {
        String temp = email.substring(email.indexOf("@") + 1);
        return temp.substring(0, temp.indexOf("."));
    }

    public String getDomainExtension() {
        return email.substring(email.lastIndexOf(".") + 1);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + email;
    }
}
