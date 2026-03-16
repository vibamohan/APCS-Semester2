
import java.awt.*;

public class Square {

    private Color color;

    public Square(Color c) {
        color = c;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public void drawMe(Graphics g, int x, int y, int size) {

        g.setColor(color);
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
