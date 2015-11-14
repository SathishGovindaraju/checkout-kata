package main;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private int total = 0;

    public int checkout() {
        if(items.size() == 0) {
            total = 0;
        }

        for (Item item : items) {

            if(item.getItemName().equals("A")){
                total += 50;
            } else if(item.getItemName().equals("B")){
                total += 30;
            } else if(item.getItemName().equals("C")){
                total += 20;
            } else if(item.getItemName().equals("D")){
                total += 15;
            }
        }

        return total;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
