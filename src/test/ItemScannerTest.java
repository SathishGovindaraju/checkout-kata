import main.Item;
import main.ItemScanner;
import main.PriceCalculator;
import main.ShoppingCart;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ItemScannerTest {
    private static final Item A = new Item("A");
    private static final Item B = new Item("B");

    private PriceCalculator priceCalculator = new PriceCalculator(new HashMap<>(), new HashMap<>());
    private ShoppingCart shoppingCart = new ShoppingCart(priceCalculator);
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

    @Test
    public void shouldUpdateShoppingCartWithUpdatedItemCountForExistingMultipleItems(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        assertTrue(shoppingCart.getItems().size() == 2);

        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(B);

        assertTrue(shoppingCart.getItems().size() == 2);
        assertTrue(shoppingCart.getItems().get(A) == 3);
        assertTrue(shoppingCart.getItems().get(B) == 2);

    }
}