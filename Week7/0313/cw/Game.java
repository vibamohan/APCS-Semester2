

public class Game {

    private int[][] table;
    private int turn;

    public Game() {
        table = new int[3][3];
        turn = 1;
    }

    public void printTable() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (table[r][c] == 1) {
                    System.out.print("X "); 
                }else if (table[r][c] == 2) {
                    System.out.print("O "); 
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // Insert X or O (NO LOOPS)
    public void insertXO(int row, int col) {

        // check bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid location. Turn lost.");
            switchTurn();
            return;
        }

        // check if already played
        if (table[row][col] != 0) {
            System.out.println("Spot already taken. Turn lost.");
            switchTurn();
            return;
        }

        // place move
        table[row][col] = turn;

        // change turn
        switchTurn();
    }

    // helper method
    private void switchTurn() {
        if (turn == 1) {
            turn = 2; 
        }else {
            turn = 1;
        }
    }

    // Check if board is full
    public boolean checkFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (table[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Check for Tic Tac Toe
    public int checkTicTacToe() {

        // rows
        for (int r = 0; r < 3; r++) {
            if (table[r][0] != 0
                    && table[r][0] == table[r][1]
                    && table[r][1] == table[r][2]) {
                return table[r][0];
            }
        }

        // columns
        for (int c = 0; c < 3; c++) {
            if (table[0][c] != 0
                    && table[0][c] == table[1][c]
                    && table[1][c] == table[2][c]) {
                return table[0][c];
            }
        }

        // diagonals
        if (table[0][0] != 0
                && table[0][0] == table[1][1]
                && table[1][1] == table[2][2]) {
            return table[0][0];
        }

        if (table[0][2] != 0
                && table[0][2] == table[1][1]
                && table[1][1] == table[2][0]) {
            return table[0][2];
        }

        return 0;
    }
}
