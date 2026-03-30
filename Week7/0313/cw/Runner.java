
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Game game = new Game();

        while (true) {

            // PLAYER 1
            game.printTable();
            System.out.println("Player 1 (X) enter row and column:");
            int r1 = input.nextInt();
            int c1 = input.nextInt();

            game.insertXO(r1, c1);
            game.printTable();

            int winner = game.checkTicTacToe();
            if (winner != 0) {
                System.out.println("Player " + winner + " wins!");
                break;
            }

            if (game.checkFull()) {
                System.out.println("Board full. Game over.");
                break;
            }

            // PLAYER 2
            System.out.println("Player 2 (O) enter row and column:");
            int r2 = input.nextInt();
            int c2 = input.nextInt();

            game.insertXO(r2, c2);
            game.printTable();

            winner = game.checkTicTacToe();
            if (winner != 0) {
                System.out.println("Player " + winner + " wins!");
                break;
            }

            if (game.checkFull()) {
                System.out.println("Board full. Game over.");
                break;
            }
        }

        input.close();
    }
}
