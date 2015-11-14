package main;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private int total = 0;
    private Map<Item, Integer> items = new HashMap<>();
    private Map<Item,Integer> itemNormalPrices = new HashMap<>();

    public ShoppingCart(Map<Item, Integer> itemNormalPrices){
        this.itemNormalPrices = itemNormalPrices;
    }

    public int totalPrice() {
        for (Item item : items.keySet()) {
            total += itemNormalPrices.get(item) * items.get(item);
        }
        return total;
    }

    public Map<Item, Integer> getItems(){
        return items;
    }

    public void updateItems(Map<Item, Integer> shoppingCartItems) {
        this.items = shoppingCartItems;
    }
}
