
import java.util.Random;

public final class BlackJack {

    private Card[] deck = new Card[52];
    private int deckIndex = 0;
    private Card[] playerHand = new Card[12];
    private int handSize = 0;
    private int totalPoints = 20;
    private boolean gameOver = false;

    public BlackJack() {
        initializeDeck();
        shuffleDeck();
        dealCard();
        dealCard();
    }

    public void initializeDeck() {
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        String[] names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        int index = 0;
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                deck[index++] = new Card(suit, names[i], values[i]);
            }
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int j = rand.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        deckIndex = 0;
    }

    public void dealCard() {
        if (deckIndex < deck.length && !gameOver) {
            playerHand[handSize++] = deck[deckIndex++];
            if (calculateHandValue() > 21) {
                gameOver = true;
            }
        }
    }

    public int calculateHandValue() {
        int sum = 0;
        for (int i = 0; i < handSize; i++) {
            sum += playerHand[i].getValue();
        }
        return sum;
    }

    public void hit() {
        dealCard();
    }

    public void stand() {
        gameOver = true;
    }

    public void newGame() {
        if (totalPoints > 0) {
            totalPoints--;
            handSize = 0;
            deckIndex = 0;
            gameOver = false;
            initializeDeck();
            shuffleDeck();
            dealCard();
            dealCard();
        }
    }

    public Card[] getPlayerHand() {
        return playerHand;
    }

    public int getHandSize() {
        return handSize;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int calculatePointsWon() {
        int value = calculateHandValue();
        if (value == 21) {
            return 5;
        }
        if (value == 20) {
            return 3;
        }
        if (value == 19 || value == 18) {
            return 2;
        }
        if (value == 17 || value == 16) {
            return 1;
        }
        return 0;
    }
}
