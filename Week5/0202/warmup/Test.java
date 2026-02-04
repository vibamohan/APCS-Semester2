
import java.util.ArrayList;


public class Test {
    public void scramble(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int swapIndex = (int) (Math.random() * list.size());

            String temp = list.get(i);
            list.set(i, list.get(swapIndex));
            list.set(swapIndex, temp);
        }
    }

    public void changeNum(int i) {
        i = 99;
    }
}