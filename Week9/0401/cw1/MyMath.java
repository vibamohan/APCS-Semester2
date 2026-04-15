public class MyMath {
    public void countDown(int number) {
        if (number < 0) {
            return;
        }

        System.out.println(number);

        if (number == 0) {
            return;
        }

        countDown(number - 1);
    }

    public void countUp(int number) {
        countUpHelper(1, number);
    }

    private void countUpHelper(int current, int target) {
        if (current > target) {
            return;
        }

        System.out.println(current);
        countUpHelper(current + 1, target);
    }

    public int factorial(int number) {
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public int summation(int number) {
        if (number <= 1) {
            return number;
        }

        return number + summation(number - 1);
    }
}
