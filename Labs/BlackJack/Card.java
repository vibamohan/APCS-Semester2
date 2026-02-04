
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Card {

    private final String suit;
    private final String name;
    private final int value;
    private Image image;

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    private void generateImageName() {
        String imageName = suit + "-" + name + "-" + value + ".png";
        image = GameImage()
        
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public Image getImage() {
        return image;
    }

    public String toString() {
        return name + " of " + suit;
    }
}
