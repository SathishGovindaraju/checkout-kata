import main.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemScannerTest {
    private static final Item A = new ItemA();
    private static final Item B = new ItemB();

    private ShoppingCart shoppingCart = new ShoppingCart();
    private ItemScanner scanner = new ItemScanner(shoppingCart);

    @Test
    public void shouldUpdateShoppingCartWithNewlyAddedItem(){
        assertTrue(shoppingCart.getItemsInCart().size() == 0);

        scanner.scanItem(A);

        assertTrue(shoppingCart.getItemsInCart().size() == 1);
        assertTrue(shoppingCart.getItemsInCart().get(A) == 1);
    }

    @Test
    public void shouldUpdateShoppingCartWithUpdatedItemCountForExistingItem(){
        scanner.scanItem(A);
        assertTrue(shoppingCart.getItemsInCart().size() == 1);

        scanner.scanItem(A);

        assertTrue(shoppingCart.getItemsInCart().size() == 1);
        assertTrue(shoppingCart.getItemsInCart().get(A) == 2);

    }

    @Test
    public void shouldUpdateShoppingCartWithUpdatedItemCountForExistingMultipleItems(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        assertTrue(shoppingCart.getItemsInCart().size() == 2);

        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(B);

        assertTrue(shoppingCart.getItemsInCart().size() == 2);
        assertTrue(shoppingCart.getItemsInCart().get(A) == 3);
        assertTrue(shoppingCart.getItemsInCart().get(B) == 2);

    }
}