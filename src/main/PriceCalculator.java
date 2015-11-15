package main;

import java.util.Map;

public final class PriceCalculator {
    private static Map<Item, Integer> normalPrices;
    private static Map<Item, Discount> discountPrices;

    private PriceCalculator(){}

    public static int calculatePriceForItems(Map<Item, Integer> items) {
        getLatestPrices();

        if(isNormalPriceNotAvailable()){
            return 0;
        }
        int total = 0;
        for (Item item : items.keySet()) {
            final boolean itemHasDiscount = hasDiscountForItem(item);
            final Integer normalItemPrice = normalPrices.get(item);
            final int numberOfItem = items.get(item);
            if(itemHasDiscount){
                final int itemThreshold = getItemThresholdForDiscount(item);
                final int discountPrice = getItemDiscountPrice(item);
                total = total +
                        calculateNormalPrice(normalItemPrice, numberOfItem, itemThreshold) +
                        calculateDiscountPrice(discountPrice, numberOfItem, itemThreshold);
            }else {
                total = total +
                        (normalItemPrice * numberOfItem);
            }
        }

        return total;
    }

    private static boolean isNormalPriceNotAvailable() {
        return normalPrices.size() == 0;
    }

    private static void getLatestPrices() {
        normalPrices = PriceHolder.getNormalPrices();
        discountPrices = PriceHolder.getDiscountPrices();
    }

    private static int calculateDiscountPrice(int discountPrice, int numberOfItem, int itemThreshold) {
        return ((numberOfItem - (numberOfItem % itemThreshold))/ itemThreshold) * discountPrice;
    }

    private static int calculateNormalPrice(int normalItemPrice, int numberOfItem, int itemThreshold) {
        return (numberOfItem % itemThreshold) * normalItemPrice;
    }

    private static int getItemDiscountPrice(Item item) {
        return discountPrices.get(item).getTotalDiscountPrice();
    }

    private static int getItemThresholdForDiscount(Item item) {
        return discountPrices.get(item).getItemThreshold();
    }

    private static boolean hasDiscountForItem(Item item) {
        return discountPrices.containsKey(item);
    }
}
