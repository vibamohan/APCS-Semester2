
public class MyMath {

    /**
     * Performs a binary search on a sorted array to find a target value.
     *
     * @param array the sorted array to search
     * @param search the value to search for
     * @param start the starting index of the search range
     * @param end the ending index of the search range
     * @return the index of the search value if found, -1 otherwise
     */
    public static int binarySearch(int[] array, int search, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (array[mid] == search) {
            return mid;
        } else if (array[mid] < search) {
            return binarySearch(array, search, mid + 1, end);
        } else {
            return binarySearch(array, search, start, mid - 1);
        }
    }
}
