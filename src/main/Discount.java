package main;

public class Discount {
    private final int itemThreshold;
    private final int totalDiscountPrice;

    public Discount(int itemThreshold, int totalDiscountPrice){
        this.itemThreshold = itemThreshold;
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public int getItemThreshold() {
        return itemThreshold;
    }
}
