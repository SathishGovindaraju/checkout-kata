package main;

import java.util.Map;

public class ItemScanner {
    private ShoppingCart shoppingCart;

    public ItemScanner(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void scanItem(Item item) {
        Map<Item, Integer> shoppingCartItems = shoppingCart.getItemsInCart();
        final Integer itemCount = getExistingCountForItem(item, shoppingCartItems);
        if(itemCount == null){
            shoppingCartItems.put(item, 1);
        }else{
            shoppingCartItems.put(item, itemCount+1);
        }
        shoppingCart.updateCart(shoppingCartItems);
    }

    private Integer getExistingCountForItem(Item item, Map<Item, Integer> shoppingCartItems) {
        return shoppingCartItems.get(item);
    }
}
