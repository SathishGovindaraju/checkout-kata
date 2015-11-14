import main.Item;
import main.ItemScanner;
import main.PriceCalculator;
import main.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AcceptanceTest {

    private static final Item A = new Item("A");
    private static final Item B = new Item("B");
    private static final Item C = new Item("C");
    private static final Item D = new Item("D");

    private ShoppingCart shoppingCart;
    private ItemScanner scanner;
    private PriceCalculator priceCalculator;

    @Before
    public void setUp(){
        priceCalculator = new PriceCalculator(getItemNormalPrices());
        shoppingCart = new ShoppingCart(priceCalculator);
        scanner = new ItemScanner(shoppingCart);
    }

    @Test
    public void shouldReturnZero_whenShoppingCartIsEmpty(){
        assertTrue(shoppingCart.checkout() == 0);
    }

    @Test
    public void shouldReturn_50_whenItem_A_checkedOut(){
        scanner.scanItem(A);
        assertTrue(shoppingCart.checkout() == 50);
    }

    @Test
    public void shouldReturn_30_whenItem_B_checkedOut(){
        scanner.scanItem(B);
        assertTrue(shoppingCart.checkout() == 30);
    }

    @Test
    public void shouldReturn_20_whenItem_C_checkedOut(){
        scanner.scanItem(C);
        assertTrue(shoppingCart.checkout() == 20);
    }

    @Test
    public void shouldReturn_15_whenItem_D_checkedOut(){
        scanner.scanItem(D);
        assertTrue(shoppingCart.checkout() == 15);
    }

    @Test
    public void shouldReturn_100_when_2_Item_A_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        assertTrue(shoppingCart.checkout() == 100);
    }

    @Test
    public void shouldReturn_60_when_2_Item_B_checkedOut(){
        scanner.scanItem(B);
        scanner.scanItem(B);
        assertTrue(shoppingCart.checkout() == 60);
    }

    @Test
    public void shouldReturn_40_when_2_Item_C_checkedOut(){
        scanner.scanItem(C);
        scanner.scanItem(C);
        assertTrue(shoppingCart.checkout() == 40);
    }

    @Test
    public void shouldReturn_30_when_2_Item_D_checkedOut(){
        scanner.scanItem(D);
        scanner.scanItem(D);
        assertTrue(shoppingCart.checkout() == 30);
    }

    @Test
    public void shouldReturn_80_when_Items_A_B_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        assertTrue(shoppingCart.checkout() == 80);
    }

    @Test
    public void shouldReturn_100_when_Items_A_B_C_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(C);
        assertTrue(shoppingCart.checkout() == 100);
    }

    @Test
    public void shouldReturn_115_when_Items_A_B_C_D_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(C);
        scanner.scanItem(D);
        assertTrue(shoppingCart.checkout() == 115);
    }

    private Map<Item, Integer> getItemNormalPrices() {
        Map<Item,Integer> itemPrices = new HashMap<>();
        itemPrices.put(A, 50);
        itemPrices.put(B, 30);
        itemPrices.put(C, 20);
        itemPrices.put(D, 15);
        return itemPrices;
    }
}
