
import java.util.ArrayList;

public class Runner {

    public static void main(String args[]) {
        //What do you have to import to use ArrayList?
        //java.util.ArrayList
        //What do you think the ? in ArrayList< ? > represents?
        // type of objects being stored (Song)
        ArrayList<Song> songList1 = new ArrayList<Song>();
        ArrayList<Song> songList2 = new ArrayList<>();

        //What do you think the method add() does?
        //Adds to the array
        songList1.add(new Song("John", "Happy"));
        songList1.add(new Song("Jose", "Hello"));

        songList2.add(new Song("Bruno Mars", "I just might"));
        songList2.add(new Song("Oliva Need", "Man I need"));
        songList2.add(new Song("Taylor Swift", "The Fate of Ophelia"));

        System.out.println(songList2.get(0));
        System.out.println(songList2.get(2));

        //What do you think the method get() does?
        // it accesses value at the index
        //What method gets called by default when you don't use getName() ?
        // toString()
        System.out.println();
        System.out.println(songList1.get(0).getName());
        System.out.println(songList1.get(1).getName());
        System.out.println(songList1.get(0));
        System.out.println(songList1.get(1));

        //What do you think the method set() does?
        //It places the value at the index and pushes back everything else 
        System.out.println();
        songList1.set(1, new Song("Jen", "Happy Days"));
        System.out.println(songList1.get(1));

    }
}
