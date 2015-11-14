package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private int total = 0;
    private static Map<Item,Integer> itemPrices = new HashMap<>();
    static {
        itemPrices.put(new Item("A"), 50);
        itemPrices.put(new Item("B"), 30);
        itemPrices.put(new Item("C"), 20);
        itemPrices.put(new Item("D"), 15);
    }

    public int checkout() {
        if(items.size() == 0) {
            total = 0;
        }

        for (Item item : items) {

            total += itemPrices.get(item);
        }

        return total;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
