public class Runner {
    public static void main(String[] args) {
        StringReview sr = new StringReview();

        char c1 = sr.getChar("Hello World!", 2);
        System.out.println(c1);

        char c2 = sr.getChar("Hello World!", 1);
        System.out.println(c2);

        int countO = sr.countChar("Hello World!", 'o');
        System.out.println(countO);

        int countL = sr.countChar("Hello World!", 'l');
        System.out.println(countL);
    }
}
