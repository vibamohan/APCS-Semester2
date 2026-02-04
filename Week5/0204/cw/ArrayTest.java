
import java.util.ArrayList;

public class ArrayTest {

    public void printList(ArrayList<Card> cardList) {
        for (Card c : cardList) {
            System.out.println(c);
        }
        System.out.println();
    }

    public int findTotal(ArrayList<Card> cardList) {
        int sum = 0;
        for (Card c : cardList) {
            sum += c.getValue();
        }
        return sum;
    }

    public void searchAndDelete(ArrayList<Card> cardList, int value) {
        for (int i = cardList.size() - 1; i >= 0; i--) {
            if (cardList.get(i).getValue() == value) {
                cardList.remove(i);
            }
        }
    }

    public void scramble(ArrayList<Card> cardList) {
        for (int i = 0; i < cardList.size(); i++) {
            int r = (int) (Math.random() * cardList.size());
            Card temp = cardList.get(i);
            cardList.set(i, cardList.get(r));
            cardList.set(r, temp);
        }
    }

    public void searchAndReplace(ArrayList<Card> cardList, int value) {
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getValue() == value) {
                cardList.set(i, new Card(99));
            }
        }
    }

    public void sort(ArrayList<Card> cardList) {
        for (int i = 0; i < cardList.size() - 1; i++) {
            for (int j = 0; j < cardList.size() - 1 - i; j++) {
                if (cardList.get(j).getValue() > cardList.get(j + 1).getValue()) {
                    Card temp = cardList.get(j);
                    cardList.set(j, cardList.get(j + 1));
                    cardList.set(j + 1, temp);
                }
            }
        }
    }
}
