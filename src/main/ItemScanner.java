package main;

import java.util.Map;

public class ItemScanner {
    private ShoppingCart shoppingCart;

    public ItemScanner(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void scanItem(Item item) {
        Map<Item, Integer> shoppingCartItems = shoppingCart.getItems();
        final Integer itemCount = shoppingCartItems.get(item);
        if(itemCount == null){
            shoppingCartItems.put(item, 1);
        }else{
            shoppingCartItems.put(item, itemCount+1);
        }
        shoppingCart.updateItems(shoppingCartItems);
    }
}
