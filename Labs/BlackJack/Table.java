
import javax.swing.*;
import java.awt.*;

public class Table extends JPanel {

    private BlackJack game;
    private JButton hitButton, standButton, playAgainButton;
    private JLabel pointsLabel, totalLabel;

    public Table() {
        game = new BlackJack();
        setLayout(null);

        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        playAgainButton = new JButton("Play Again");
        pointsLabel = new JLabel("Points: " + game.getTotalPoints());
        totalLabel = new JLabel("Total: " + game.calculateHandValue());

        hitButton.setBounds(50, 400, 100, 30);
        standButton.setBounds(200, 400, 100, 30);
        playAgainButton.setBounds(350, 400, 120, 30);
        pointsLabel.setBounds(50, 350, 200, 30);
        totalLabel.setBounds(250, 350, 200, 30);

        add(hitButton);
        add(standButton);
        add(playAgainButton);
        add(pointsLabel);
        add(totalLabel);

        hitButton.addActionListener(e -> {
            if (!game.isGameOver()) {
                game.hit();
                totalLabel.setText("Total: " + game.calculateHandValue());
                if (game.isGameOver()) {
                    showResult();
                }
                repaint();
            }
        });

        standButton.addActionListener(e -> {
            if (!game.isGameOver()) {
                game.stand();
                showResult();
            }
        });

        playAgainButton.addActionListener(e -> {
            if (game.isGameOver()) {
                game.newGame();
                pointsLabel.setText("Points: " + game.getTotalPoints());
                totalLabel.setText("Total: " + game.calculateHandValue());
                repaint();
            }
        });
    }

    private void showResult() {
        int won = game.calculatePointsWon();

        if (won > 0) {
            game.addPoints(won);
            JOptionPane.showMessageDialog(this, "You won " + won + " points!");
        } else {
            JOptionPane.showMessageDialog(this, "You lost!");
        }

        pointsLabel.setText("Points: " + game.getTotalPoints());

        if (game.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game is over");
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Card[] hand = game.getPlayerHand();
        for (int i = 0; i < game.getHandSize(); i++) {
            int x = 50 + i * 70;
            g.drawRect(x, 50, 60, 90);
            g.drawString(hand[i].getName(), x + 5, 80);
            g.drawString(hand[i].getSuit(), x + 5, 95);
        }

        int tableX = 500;
        int tableY = 50;
        int rowHeight = 25;
        int col1Width = 50;
        int col2Width = 50;

        g.setColor(Color.BLACK);
        g.drawRect(tableX, tableY, col1Width, rowHeight);
        g.drawRect(tableX + col1Width, tableY, col2Width, rowHeight);
        g.drawString("Value", tableX + 5, tableY + 17);
        g.drawString("Pts", tableX + col1Width + 5, tableY + 17);

        int[][] table = {
            {21, 5},
            {20, 3},
            {19, 2},
            {18, 2},
            {17, 1},
            {16, 1}
        };

        for (int i = 0; i < table.length; i++) {
            int y = tableY + (i + 1) * rowHeight;
            g.drawRect(tableX, y, col1Width, rowHeight);
            g.drawRect(tableX + col1Width, y, col2Width, rowHeight);
            g.drawString(String.valueOf(table[i][0]), tableX + 10, y + 17);
            g.drawString(String.valueOf(table[i][1]), tableX + col1Width + 10, y + 17);
        }
    }
}
