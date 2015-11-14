package test;

import main.Item;
import main.ItemScanner;
import main.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ShoppingCartTest {

    private static final Item A = new Item("A");
    private static final Item B = new Item("B");
    private static final Item C = new Item("C");
    private static final Item D = new Item("D");

    private ShoppingCart shoppingCart;
    private ItemScanner scanner;

    @Before
    public void setUp(){
        shoppingCart = new ShoppingCart(getItemNormalPrices());
        scanner = new ItemScanner(shoppingCart);
    }

    @Test
    public void shouldReturnZero_whenShoppingCartIsEmpty(){
        assertTrue(shoppingCart.totalPrice() == 0);
    }

    @Test
    public void shouldReturn_50_whenItem_A_scanned(){
        scanner.scanItem(A);
        assertTrue(shoppingCart.totalPrice() == 50);
    }

    @Test
    public void shouldReturn_30_whenItem_B_scanned(){
        scanner.scanItem(B);
        assertTrue(shoppingCart.totalPrice() == 30);
    }

    @Test
    public void shouldReturn_20_whenItem_C_scanned(){
        scanner.scanItem(C);
        assertTrue(shoppingCart.totalPrice() == 20);
    }

    @Test
    public void shouldReturn_15_whenItem_D_scanned(){
        scanner.scanItem(D);
        assertTrue(shoppingCart.totalPrice() == 15);
    }

    @Test
    public void shouldReturn_100_when_2_Item_A_scanned(){
        scanner.scanItem(A);
        scanner.scanItem(A);
        assertTrue(shoppingCart.totalPrice() == 100);
    }

    @Test
    public void shouldReturn_60_when_2_Item_B_scanned(){
        scanner.scanItem(B);
        scanner.scanItem(B);
        assertTrue(shoppingCart.totalPrice() == 60);
    }

    @Test
    public void shouldReturn_40_when_2_Item_C_scanned(){
        scanner.scanItem(C);
        scanner.scanItem(C);
        assertTrue(shoppingCart.totalPrice() == 40);
    }

    @Test
    public void shouldReturn_30_when_2_Item_D_scanned(){
        scanner.scanItem(D);
        scanner.scanItem(D);
        assertTrue(shoppingCart.totalPrice() == 30);
    }

    @Test
    public void shouldReturn_80_when_Items_A_B_scanned(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        assertTrue(shoppingCart.totalPrice() == 80);
    }

    @Test
    public void shouldReturn_100_when_Items_A_B_C_scanned(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(C);
        assertTrue(shoppingCart.totalPrice() == 100);
    }

    @Test
    public void shouldReturn_115_when_Items_A_B_C_D_scanned(){
        scanner.scanItem(A);
        scanner.scanItem(B);
        scanner.scanItem(C);
        scanner.scanItem(D);
        assertTrue(shoppingCart.totalPrice() == 115);
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
