
import java.util.Arrays;

public class ArrayTest {

    private final int[] numArray;

    public ArrayTest(int size) {
        numArray = new int[size];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (Math.random() * 5);
        }
    }

    public void printArray() {
        for (int x : numArray) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
    }

    public int search(int target) {
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void scramble() {
        for (int i = numArray.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = numArray[i];
            numArray[i] = numArray[j];
            numArray[j] = temp;
        }
    }

    public void sort() {
        for (int i = 0; i < numArray.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numArray.length - 1 - i; j++) {
                if (numArray[j] > numArray[j + 1]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[j + 1];
                    numArray[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
