package main;

import java.util.Map;

public class PriceCalculator {
    private Map<Item, Integer> itemPrices;
    private int total = 0;

    public PriceCalculator(Map<Item, Integer> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public int calculatePriceForItems(Map<Item, Integer> items) {
        for (Item item : items.keySet()) {
            total += itemPrices.get(item) * items.get(item);
        }
        return total;
    }
}
