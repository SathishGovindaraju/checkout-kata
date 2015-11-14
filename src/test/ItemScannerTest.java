import main.Item;
import main.ItemScanner;
import main.ShoppingCart;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ItemScannerTest {
    private static final Item A = new Item("A");

    private ShoppingCart shoppingCart = new ShoppingCart(new HashMap<>());
    private ItemScanner scanner = new ItemScanner(shoppingCart);


    @Test
    public void shouldUpdateShoppingCartWithNewlyAddedItem(){
        assertTrue(shoppingCart.getItems().size() == 0);

        scanner.scanItem(A);

        assertTrue(shoppingCart.getItems().size() == 1);
        assertTrue(shoppingCart.getItems().get(A) == 1);
    }

    @Test
    public void shouldUpdateShoppingCartWithUpdatedItemCountForExistingItem(){
        scanner.scanItem(A);
        assertTrue(shoppingCart.getItems().size() == 1);

        scanner.scanItem(A);

        assertTrue(shoppingCart.getItems().size() == 1);
        assertTrue(shoppingCart.getItems().get(A) == 2);

    }
}