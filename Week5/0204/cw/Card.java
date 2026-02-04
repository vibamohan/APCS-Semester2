
import java.awt.*;

public class Card {

    private int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "value: " + value;
    }

    public void drawMe(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 60, 90);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 60, 90);
        g.drawString("" + value, x + 25, y + 50);
    }
}
