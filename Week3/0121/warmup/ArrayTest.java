public class ArrayTest {
    private String[] words;

    public ArrayTest() {
        words = new String[] {
            "dog",
            "cat",
            "elephant",
            "lion",
            "tiger"
        };
    }

    public void printWords() {
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    public void swapWords(int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
