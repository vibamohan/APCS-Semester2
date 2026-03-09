
import java.util.Scanner;

public class Array2DDemo {

    public void print2DInt(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] test1() {
        int[][] arr = new int[5][5];

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                arr[r][c] = (int) (Math.random() * 10) + 1;
            }
        }

        return arr;
    }

    public void test2() {
        int[][] arr = test1();

        print2DInt(arr);

        int largest = arr[0][0];

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] > largest) {
                    largest = arr[r][c];
                }
            }
        }

        System.out.println("Largest: " + largest);
    }

    public void test3() {
        Scanner sc = new Scanner(System.in);
        int[][] arr = test1();

        print2DInt(arr);

        System.out.print("Enter number (1-10) to change to 99: ");
        int num = sc.nextInt();

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == num) {
                    arr[r][c] = 99;
                }
            }
        }

        print2DInt(arr);
    }

    public void test4() {
        Scanner sc = new Scanner(System.in);

        String[][] animals = {
            {"cat", "dog", "lion"},
            {"tiger", "bear", "wolf"},
            {"zebra", "horse", "elephant"}
        };

        for (int r = 0; r < animals.length; r++) {
            for (int c = 0; c < animals[r].length; c++) {
                System.out.print(animals[r][c] + "\t");
            }
            System.out.println();
        }

        System.out.print("Enter animal: ");
        String input = sc.nextLine();

        boolean found = false;

        for (int r = 0; r < animals.length; r++) {
            for (int c = 0; c < animals[r].length; c++) {
                if (animals[r][c].equalsIgnoreCase(input)) {
                    System.out.println("yes " + r + " " + c);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("no");
        }
    }
}
