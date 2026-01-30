public class Runner {
    public static void main(String[] args) {
        ArrayTest arr = new ArrayTest(5);

        arr.printArray();
        arr.scramble();
        arr.printArray();

        int result = arr.search(0);
        System.out.println(result);

        arr.sort();
        arr.printArray();
    }
}
