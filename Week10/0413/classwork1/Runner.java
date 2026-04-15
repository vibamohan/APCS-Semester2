
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        int[] myArray = new int[]{2, 4, 7, 10, 22, 33, 45, 62, 94, 100};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Array: " + java.util.Arrays.toString(myArray));
        System.out.print("Enter a number to search for: ");
        int searchNumber = scanner.nextInt();

        int result = MyMath.binarySearch(myArray, searchNumber, 0, myArray.length - 1);

        if (result == -1) {
            System.out.println("The number " + searchNumber + " was not found in the array.");
        } else {
            System.out.println("The number " + searchNumber + " was found at index: " + result);
        }

        scanner.close();
    }
}
