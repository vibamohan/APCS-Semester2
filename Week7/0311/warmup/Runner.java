
public class Runner {

    public static void main(String[] args) {
        int[][] nums = new int[2][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        Array2D arrayHelper = new Array2D();
        System.out.println("Original array:");
        arrayHelper.print(nums);
        arrayHelper.scramble(nums);
        System.out.println("Scrambled array:");
        arrayHelper.print(nums);
    }
}
