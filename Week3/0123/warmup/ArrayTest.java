
import java.util.Random;

public class ArrayTest {

    private final int[] nums;

    public ArrayTest() {
        nums = new int[10];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(99) + 1;
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            if (i < nums.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public void sort() {
        quickSort(0, nums.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
