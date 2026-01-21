
public class ArrayTest {

    public void printArray(int[] a) {
        for (int each : a) {
            System.out.println(each);
        }
        System.out.println();
    }

    public int search(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Uses selection sort to sort an array
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_ind = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_ind]) {
                    min_ind = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
    }

    public void scramble(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
