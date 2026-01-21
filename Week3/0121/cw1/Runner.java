
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10 + 1);
        }

        ArrayTest t1 = new ArrayTest();

        t1.printArray(nums);
        t1.scramble(nums);
        t1.printArray(nums);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = scan.nextInt();
        t1.search(num, nums);

        t1.sort(nums);
        t1.printArray(nums);
    }
}
