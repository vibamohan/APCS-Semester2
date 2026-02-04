
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                    showPoints();
                }
                repaint();
            }
        });

        standButton.addActionListener(e -> {
            if (!game.isGameOver()) {
                game.stand();
                showPoints();
            }
        });

        playAgainButton.addActionListener(e -> {
            game.newGame();
            pointsLabel.setText("Points: " + game.getTotalPoints());
            totalLabel.setText("Total: " + game.calculateHandValue());
            repaint();
        });
    }

    private void showPoints() {
        int won = game.calculatePointsWon();
        JOptionPane.showMessageDialog(this, "You won " + won + " points!");
        pointsLabel.setText("Points: " + (game.getTotalPoints() + won));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Card[] hand = game.getPlayerHand();
        for (int i = 0; i < game.getHandSize(); i++) {
            g.drawRect(50 + i * 70, 50, 60, 90);
            g.drawString(hand[i].toString(), 55 + i * 70, 100);
        }
    }
}
