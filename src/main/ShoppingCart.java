package main;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> items = new HashMap<>();
    private PriceCalculator priceCalculator;

    public ShoppingCart(PriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }

    public int totalPrice() {
        return priceCalculator.calculatePriceForItems(items);
    }

    public Map<Item, Integer> getItems(){
        return items;
    }

    public void updateItems(Map<Item, Integer> shoppingCartItems) {
        this.items = shoppingCartItems;
    }
}
