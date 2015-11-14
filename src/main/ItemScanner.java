package main;

public class ItemScanner {
    private ShoppingCart shoppingCart;

    public ItemScanner(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void scanItem(Item item) {
        shoppingCart.addItem(item);
    }
}
