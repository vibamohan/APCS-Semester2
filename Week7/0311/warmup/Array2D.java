
class Array2D {

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void scramble(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[] flat = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flat[index++] = arr[i][j];
            }
        }
        for (int i = flat.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = flat[i];
            flat[i] = flat[j];
            flat[j] = temp;
        }
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = flat[index++];
            }
        }
    }
}
