package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private int total = 0;
    private Map<Item, Integer> items = new HashMap<>();
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

        for (Item item : items.keySet()) {
            total += itemPrices.get(item) * items.get(item);
        }

        return total;
    }

    public void addItem(Item item) {
        final Integer itemCount = items.get(item);
        if(itemCount == null){
            this.items.put(item, 1);
        }else{
            this.items.put(item, itemCount+1);
        }
    }
}
