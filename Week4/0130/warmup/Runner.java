
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        ArrayListTest alt = new ArrayListTest();
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numList.add((int) (Math.random() * 10 + 1));
        }

        System.out.print("Original list: ");
        alt.print(numList);

        alt.sort(numList);

        System.out.print("Sorted list: ");
        alt.print(numList);
    }
}