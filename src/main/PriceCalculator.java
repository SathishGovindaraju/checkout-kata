package main;

import java.util.HashMap;
import java.util.Map;

public class PriceCalculator {
    private Map<Item, Integer> itemPrices;
    private Map<Item, Discount> discountPrices;
    private int total = 0;

    public PriceCalculator(Map<Item, Integer> itemPrices, Map<Item, Discount> discountPrices) {
        this.itemPrices = itemPrices;
        this.discountPrices = discountPrices;
    }

    public int calculatePriceForItems(Map<Item, Integer> items) {

        for (Item item : items.keySet()) {
            final boolean itemHasDiscount = hasDiscountForItem(item);
            final Integer normalItemPrice = itemPrices.get(item);
            final int numberOfItem = items.get(item);
            if(itemHasDiscount){
                final int itemThreshold = getItemThresholdForDiscount(item);
                final int discountPrice = getItemDiscountPrice(item);
                total += ((numberOfItem % itemThreshold) * normalItemPrice) + (((numberOfItem - (numberOfItem % itemThreshold))/ itemThreshold) * discountPrice);
            }else {
                total += normalItemPrice * numberOfItem;
            }
        }

        return total;
    }

    private int getItemDiscountPrice(Item item) {
        return discountPrices.get(item).getTotalDiscountPrice();
    }

    private int getItemThresholdForDiscount(Item item) {
        return discountPrices.get(item).getItemThreshold();
    }

    private boolean hasDiscountForItem(Item item) {
        return discountPrices.containsKey(item);
    }
}
