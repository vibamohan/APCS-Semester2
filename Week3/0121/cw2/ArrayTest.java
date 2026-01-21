import java.util.Random;

public class ArrayTest {
    
    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void scramble(String[] arr) {
        Random rand = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void sort(String[] word) {
        for (int i = 0; i < word.length - 1; i++) {
            for (int j = 0; j < word.length - 1 - i; j++) {
                if (word[j].compareTo(word[j + 1]) > 0) {
                    String temp = word[j];
                    word[j] = word[j + 1];
                    word[j + 1] = temp;
                }
            }
        }
    }
}
