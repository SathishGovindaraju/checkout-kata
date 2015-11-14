package main;

import java.util.Map;

public class PriceCalculator {
    private Map<Item, Integer> normalPrices;
    private Map<Item, Discount> discountPrices;
    private int total = 0;

    public PriceCalculator(Map<Item, Integer> normalPrices, Map<Item, Discount> discountPrices) {
        this.normalPrices = normalPrices;
        this.discountPrices = discountPrices;
    }

    public int calculatePriceForItems(Map<Item, Integer> items) {

        for (Item item : items.keySet()) {
            final boolean itemHasDiscount = hasDiscountForItem(item);
            final Integer normalItemPrice = normalPrices.get(item);
            final int numberOfItem = items.get(item);
            if(itemHasDiscount){
                final int itemThreshold = getItemThresholdForDiscount(item);
                final int discountPrice = getItemDiscountPrice(item);
                total = total +
                        calculateNormalPrice(normalItemPrice, numberOfItem, itemThreshold) +
                        calculateDiscountPrice(numberOfItem, itemThreshold, discountPrice);
            }else {
                total = total +
                        (normalItemPrice * numberOfItem);
            }
        }

        return total;
    }

    private int calculateDiscountPrice(int numberOfItem, int itemThreshold, int discountPrice) {
        return ((numberOfItem - (numberOfItem % itemThreshold))/ itemThreshold) * discountPrice;
    }

    private int calculateNormalPrice(Integer normalItemPrice, int numberOfItem, int itemThreshold) {
        return (numberOfItem % itemThreshold) * normalItemPrice;
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
