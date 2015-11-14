package main;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> items = new HashMap<>();
    private PriceCalculator priceCalculator = new PriceCalculator();

    public int checkout() {
        return priceCalculator.calculatePriceForItems(items);
    }

    public Map<Item, Integer> getItemsInCart(){
        return items;
    }

    public void updateCart(Map<Item, Integer> shoppingCartItems) {
        this.items = shoppingCartItems;
    }
}
