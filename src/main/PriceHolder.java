package main;

import java.util.Map;

public final class PriceHolder {

    private static Map<Item, Integer> normalPrices;
    private static Map<Item, Discount> discountPrices;

    private  PriceHolder(){}

    public static Map<Item, Integer> getNormalPrices() {
        return normalPrices;
    }

    public static Map<Item, Discount> getDiscountPrices() {
        return discountPrices;
    }

    public static void updatePrices(Map<Item, Integer> newNormalPrices, Map<Item, Discount> newDiscountPrices) {
        normalPrices = newNormalPrices;
        discountPrices = newDiscountPrices;
    }

}