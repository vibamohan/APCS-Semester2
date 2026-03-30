import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Screen extends JPanel implements MouseListener, MouseMotionListener {

    private int rows = 40, cols = 40;
    private int gridSize = 10;
    private Square[][] grid;

    private Color selectedColor = Color.BLACK;
    private Color hoverColor = null;

    // Palette
    private java.util.List<Square> paletteSquares = new ArrayList<>();
    private java.util.List<Rectangle> paletteRects = new ArrayList<>();
    private int paletteStartX = 450;
    private int paletteStartY = 20;
    private int paletteCols = 30;
    private int paletteRows = 30;
    private int paletteSquareSize = 15;

    // Buttons
    private Rectangle clearButton = new Rectangle(450, 500, 80, 40);
    private Rectangle saveButton = new Rectangle(550, 500, 80, 40);
    private Rectangle loadButton = new Rectangle(650, 500, 80, 40);

    public Screen() {
        grid = new Square[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new Square(Color.WHITE);

        setupPalette();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private void setupPalette() {
        for (int y = 0; y < paletteRows; y++) {
            for (int x = 0; x < paletteCols; x++) {
                float hue = (float) x / (paletteCols - 1);
                float brightness = 1.0f - (float) y / (paletteRows - 1);
                float saturation = 1.0f;

                Color color = Color.getHSBColor(hue, saturation, brightness);
                paletteSquares.add(new Square(color));

                int px = paletteStartX + x * paletteSquareSize;
                int py = paletteStartY + y * paletteSquareSize;
                paletteRects.add(new Rectangle(px, py, paletteSquareSize, paletteSquareSize));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawPalette(g);
        drawButtons(g);
        drawHoverPreview(g);
    }

    private void drawGrid(Graphics g) {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c].drawMe(g, c * gridSize, r * gridSize, gridSize);
    }

    private void drawPalette(Graphics g) {
        for (int i = 0; i < paletteSquares.size(); i++) {
            paletteSquares.get(i).drawMe(g, paletteRects.get(i).x, paletteRects.get(i).y, paletteSquareSize);
        }

        for (int i = 0; i < paletteSquares.size(); i++) {
            if (paletteSquares.get(i).getColor().equals(selectedColor)) {
                Rectangle r = paletteRects.get(i);
                g.setColor(Color.WHITE);
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                g.drawRect(r.x - 1, r.y - 1, r.width + 2, r.height + 2);
            }
        }
    }

    private void drawHoverPreview(Graphics g) {
        if (hoverColor != null) {
            g.setColor(hoverColor);
            g.fillRect(450, 460, 50, 30);
            g.setColor(Color.BLACK);
            g.drawRect(450, 460, 50, 30);
            g.drawString("Hover", 510, 480);
        }
    }

    private void drawButtons(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(clearButton.x, clearButton.y, clearButton.width, clearButton.height);
        g.fillRect(saveButton.x, saveButton.y, saveButton.width, saveButton.height);
        g.fillRect(loadButton.x, loadButton.y, loadButton.width, loadButton.height);

        g.setColor(Color.BLACK);
        g.drawString("CLEAR", clearButton.x + 10, clearButton.y + 25);
        g.drawString("SAVE", saveButton.x + 20, saveButton.y + 25);
        g.drawString("LOAD", loadButton.x + 20, loadButton.y + 25);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        handleGridClick(x, y);
        handlePaletteClick(x, y);
        handleButtons(x, y);
        repaint();
    }

    private void handleGridClick(int x, int y) {
        int col = x / gridSize;
        int row = y / gridSize;
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            grid[row][col].setColor(selectedColor);
    }

    private void handlePaletteClick(int x, int y) {
        for (int i = 0; i < paletteRects.size(); i++)
            if (paletteRects.get(i).contains(x, y)) {
                selectedColor = paletteSquares.get(i).getColor();
                return;
            }
    }

    private void handleButtons(int x, int y) {
        if (clearButton.contains(x, y)) clearGrid();
        if (saveButton.contains(x, y)) saveImage();
        if (loadButton.contains(x, y)) loadImage();
    }

    private void clearGrid() {
        for (Square[] row : grid)
            for (Square s : row) s.setColor(Color.WHITE);
    }

    private void saveImage() {
        String name = JOptionPane.showInputDialog("Enter filename:");
        if (name == null) return;
        try {
            PrintWriter out = new PrintWriter(name + ".txt");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++)
                    out.print(grid[r][c].getColor().getRGB() + " ");
                out.println();
            }
            out.close();
        } catch (Exception e) { System.out.println("Save error"); }
    }

    private void loadImage() {
        String name = JOptionPane.showInputDialog("Enter filename:");
        if (name == null) return;
        try {
            Scanner scan = new Scanner(new File(name + ".txt"));
            for (int r = 0; r < rows; r++) {
                String[] nums = scan.nextLine().split(" ");
                for (int c = 0; c < cols; c++)
                    grid[r][c].setColor(new Color(Integer.parseInt(nums[c])));
            }
            scan.close();
        } catch (Exception e) { System.out.println("Load error"); }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hoverColor = null;
        int x = e.getX(), y = e.getY();
        for (int i = 0; i < paletteRects.size(); i++) {
            if (paletteRects.get(i).contains(x, y)) {
                hoverColor = paletteSquares.get(i).getColor();
                break;
            }
        }
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        handleGridClick(x, y);
        repaint();
    }

    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e) { }
}