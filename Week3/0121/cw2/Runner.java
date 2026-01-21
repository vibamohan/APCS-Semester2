
import java.util.Random;

public class Runner {

    public static void main(String[] args) {

        String[] wordPool = {
            "apple", "banana", "cherry", "grape",
            "orange", "peach", "melon", "kiwi"
        };

        String[] words = new String[5];
        Random rand = new Random();

        for (int i = 0; i < words.length; i++) {
            words[i] = wordPool[rand.nextInt(wordPool.length)];
        }

        ArrayTest.printArray(words);
        ArrayTest.scramble(words);
        ArrayTest.printArray(words);
        ArrayTest.sort(words);
        ArrayTest.printArray(words);
    }
}
