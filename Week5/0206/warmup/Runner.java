
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Cereal", 4.99));
        items.add(new Item("Milk", 3.99));
        items.add(new Item("Water", 0.99));

        double total = 0.0;
        for (Item i : items) {
            total += i.getPrice();
        }
        System.out.println("Total price: $" + total);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrice() == 0.99) {
                Item oldItem = items.get(i);
                items.set(i, new Item(oldItem.getName(), 1.25));
            }
        }

        for (Item i : items) {
            System.out.println(i);
        }
    }
}
