
import javax.swing.*;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        ArrayList<Card> cardList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cardList.add(new Card((int) (Math.random() * 9) + 1));
        }

        test.printList(cardList);
        System.out.println("Total: " + test.findTotal(cardList));
        System.out.println();

        test.scramble(cardList);
        test.printList(cardList);

        System.out.println("search and delete");
        test.searchAndDelete(cardList, 2);
        test.printList(cardList);

        System.out.println("search and replace");
        test.searchAndReplace(cardList, 4);
        test.printList(cardList);

        test.sort(cardList);
        test.printList(cardList);

        JFrame frame = new JFrame("Card Screen");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Screen());
        frame.setVisible(true);
    }
}
