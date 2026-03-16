
import javax.swing.*;

public class Runner {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pixel Art");

        Screen screen = new Screen();

        frame.add(screen);

        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
