
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

    private final ArrayList<Integer> numList;

    public Test() {
        numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add((int) (Math.random() * 10 + 1));
        }
    }

    public void printList() {
        for (int i : numList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int searchLargest() {
        int large = numList.get(0);
        for (int i = 0; i < 10; i++) {
            if (numList.get(i) > large) {
                large = numList.get(i);
            }
        }
        return large;
    }

    public void searchAndReplace(int target) {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == target) {
                numList.set(i, 1000);
            }
        }
    }

    public void searchAndRemove(int target) {
        Iterator<Integer> it = numList.iterator();
        while (it.hasNext()) {
            if (it.next() == target) {
                it.remove();
            }
        }
    }

    public void sort() {
        for (int i = 0; i < numList.size() - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numList.size() - 1 - i; j++) {
                if (numList.get(j) > numList.get(j + 1)) {
                    int temp = numList.get(j);
                    numList.set(j, numList.get(j + 1));
                    numList.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
