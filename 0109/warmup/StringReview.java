public class StringReview {
    public char getChar(String str, int index) {
        return str.charAt(index);
    }

    public int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
