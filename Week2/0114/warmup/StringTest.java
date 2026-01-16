
public class StringTest {

    private String email;

    public StringTest(String email) {
        this.email = email;
    }

    public String toString() {
        return email + " " + email.length();
    }

    public int countChar(char c) {
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public String getDomain() {
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");
        return email.substring(atIndex + 1, dotIndex);
    }
}
