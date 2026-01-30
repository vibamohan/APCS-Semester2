
public class Runner {

    public static void main(String[] args) {
        Test t1 = new Test();
        t1.printList();
        System.out.println(t1.searchLargest());
        t1.searchAndReplace(5);
        t1.printList();
        t1.searchAndRemove(2);
        t1.printList();
        t1.sort();
        t1.printList();
    }
}
