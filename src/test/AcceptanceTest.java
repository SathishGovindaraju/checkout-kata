import main.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AcceptanceTest {

    private static final Item A = new ItemA();
    private static final Item B = new ItemB();
    private static final Item C = new ItemC();
    private static final Item D = new ItemD();

    private ShoppingCart shoppingCart;
    private ItemScanner scanner;

    @BeforeClass
    public static void initialize(){
        PriceHolder.updatePrices(getNormalPrices(), getDiscountPrices());
    }

    @Before
    public void setUp(){
        shoppingCart = new ShoppingCart();
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
    public void shouldReturn_45_when_2_Item_B_checkedOut(){
        scanner.scanItem(B);
        scanner.scanItem(B);
        assertTrue(shoppingCart.checkout() == 45);
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

    @Test
    public void shouldReturn_130_when_Items_A_A_A_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        assertTrue(shoppingCart.checkout() == 130);
    }

    @Test
    public void shouldReturn_180_when_Items_A_A_A_A_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        assertTrue(shoppingCart.checkout() == 180);
    }

    @Test
    public void shouldReturn_245_when_Items_A_A_A_A_B_C_D_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(C);
        scanner.scanItem(D);
        assertTrue(shoppingCart.checkout() == 245);
    }

    @Test
    public void shouldReturn_260_when_Items_A_A_A_A_B_B_C_D_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(B);
        scanner.scanItem(C);
        scanner.scanItem(D);
        assertTrue(shoppingCart.checkout() == 260);
    }

    @Test
    public void shouldReturn_305_when_Items_A_B_A_C_D_A_B_D_A_B_checkedOut(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(A);
        scanner.scanItem(C);
        scanner.scanItem(D);
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(D);
        scanner.scanItem(A);
        scanner.scanItem(B);
        assertTrue(shoppingCart.checkout() == 305);
    }

    private static Map<Item, Integer> getNormalPrices() {
        Map<Item,Integer> itemPrices = new HashMap<>();
        itemPrices.put(A, 50);
        itemPrices.put(B, 30);
        itemPrices.put(C, 20);
        itemPrices.put(D, 15);
        return itemPrices;
    }

    private static Map<Item, Discount> getDiscountPrices() {
        Map<Item, Discount> discountedItemPrices = new HashMap<>();
        discountedItemPrices.put(A, new Discount(3,130));
        discountedItemPrices.put(B, new Discount(2,45));
        return discountedItemPrices;
    }
}
