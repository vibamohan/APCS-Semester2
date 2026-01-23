
public class Phrase {

    private String currentPhrase;

    public Phrase(String p) {
        currentPhrase = p;
    }

    public int findNthOccurrence(String str, int n) {

        int occurrence = 0;

        for (int i = 0; i < currentPhrase.length(); i++) {
            if (i + str.length() < currentPhrase.length()) {
                if (currentPhrase.substring(i, i + str.length()).equals(str)) {
                    occurrence++;
                    if (occurrence == n) {
                        return i;
                    }
                }
            }
        }

        return -1;

    }

    public void replaceNthOccurrence(String s, int n, String repl) {
        int ind = findNthOccurrence(s, n);
        if (ind == -1) {
            return;
        }

        currentPhrase = currentPhrase.substring(0, ind) + repl + currentPhrase.substring(ind + s.length());
    }

    public int findLastOccurrence(String str) {
        int index = -1;
        for (int i = 0; i < currentPhrase.length(); i++) {
            if (i + str.length() < currentPhrase.length()) {
                if (currentPhrase.substring(i, i + str.length()).equals(str)) {
                    index = i;
                }
            }
        }

        return index;
    }

    @Override
    public String toString() {
        return currentPhrase;
    }

}
