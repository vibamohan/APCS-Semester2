public class ArrayTest {
    private int[] numArray;
    private String[] stringArray;

    public ArrayTest() {
        numArray = new int[10];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int)(Math.random() * 20) + 1;
        }

        stringArray = new String[]{"dog", "cat", "elephant", "tiger", "whale"};
    }

    public void printNumArray() {
        for (int n : numArray) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public void printStringArray() {
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public void swapNumArray(int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    public void swapStringArray(int i, int j) {
        String temp = stringArray[i];
        stringArray[i] = stringArray[j];
        stringArray[j] = temp;
    }

    public int searchString(String target) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public int countLetter(char c) {
        int count = 0;
        for (String s : stringArray) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
