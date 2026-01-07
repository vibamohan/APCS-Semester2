
public class StringTest {

    private String myText;

    public StringTest(String s) {
        myText = s;
    }

    private int getLength() {
        return myText.length();
    }

    public void getInfo() {
        System.out.println("String: " + myText);
        System.out.println("Len: " + getLength());
    }

    public void printChar(int num) {
        if (num >= getLength() || num < 0) {
            System.out.println("invalid index");
        }
        System.out.println("myText at " + num + " is " + myText.charAt(num));
    }

    public void printLocation(String txt) {
        int loc = myText.indexOf(txt);
        if (loc == -1) {
            System.out.println(txt + " not found in " + myText);
        }
        System.out.println(txt + " found at " + loc + " in " + myText);
    }

    public int countChar(char c) {
        int occurences = 0;
        for (int i = 0; i < getLength(); i++) {
            if (myText.charAt(i) == c) {
                occurences++;
            }
        }
        return occurences;
    }

    public boolean contains(String txt) {
        return myText.indexOf(txt) != -1;
    }

    public int countVowels() {
        return countChar('a') + countChar('e') + countChar('i') + countChar('o') + countChar('u');
    }
}
