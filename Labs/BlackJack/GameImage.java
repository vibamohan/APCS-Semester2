
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameImage extends BufferedImage {

    private int x, y;
    private int width, height;

    public GameImage(int width, int height) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
    }

    public GameImage(int x, int y, int w, int h) {
        super(w, h, BufferedImage.TYPE_INT_ARGB);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public GameImage(String pathToFile, int x, int y, int w, int h) {
        super(w, h, BufferedImage.TYPE_INT_ARGB);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;

        try {
            BufferedImage original = ImageIO.read(new File(pathToFile));
            Image scaled = original.getScaledInstance(w, h, Image.SCALE_SMOOTH);

            Graphics2D g2 = this.createGraphics();
            g2.drawImage(scaled, 0, 0, null);
            g2.dispose();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load image: " + pathToFile, e);
        }
    }

    public void render(Graphics g) {
        g.drawImage(this, x, y, null);
    }

    public int[][] getLocationInfo() {
        return new int[][]{{x, y}, {width, height}};
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override 
    public boolean equals(Object other) {
        return super.equals(other);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }
}
