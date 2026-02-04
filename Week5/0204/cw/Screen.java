
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JPanel {

    private ArrayTest tester;
    private ArrayList<Card> cards;

    public Screen() {
        tester = new ArrayTest();
        cards = new ArrayList<>();

        cards.add(new Card(3));
        cards.add(new Card(7));
        cards.add(new Card(1));
        cards.add(new Card(9));
        cards.add(new Card(4));

        JButton scrambleBtn = new JButton("Scramble");
        JButton sortBtn = new JButton("Sort");

        scrambleBtn.addActionListener(e -> {
            tester.scramble(cards);
            repaint();
        });

        sortBtn.addActionListener(e -> {
            tester.sort(cards);
            repaint();
        });

        add(scrambleBtn);
        add(sortBtn);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 100;

        for (Card c : cards) {
            c.drawMe(g, x, y);
            x += 70;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Screen");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Screen());
        frame.setVisible(true);
    }
}
