
public class Runner {

    public static void main(String[] args) {
        StringTest s1 = new StringTest("The quick brown fox jumps over the lazy dog");
        s1.printChar(0);
        s1.printChar(5);
        s1.printChar(10);
        s1.printChar(15);
        s1.printLocation("h");
        s1.printLocation("e");
        s1.printLocation("jumps");
        s1.printLocation("dog");
        System.out.println(s1.countChar('o'));
        System.out.println(s1.contains("java"));
        System.out.println(s1.countVowels());
    }

}
