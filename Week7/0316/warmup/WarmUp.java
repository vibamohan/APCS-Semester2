
import java.util.Random;

public class WarmUp {

    public int[][] create2DArray() {
        int[][] arr = new int[4][5];

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                arr[r][c] = (int) (Math.random() * 5) + 1;
            }
        }

        return arr;
    }

    public void print(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void replace(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == 1) {
                    arr[r][c] = 0;
                }
            }
        }
    }
}
