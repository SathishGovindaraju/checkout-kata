package test;

import main.Item;
import main.ShoppingCart;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ShoppingCartTest {

    private static final Item A = new Item("A");
    private static final Item B = new Item("B");
    private static final Item C = new Item("C");
    private static final Item D = new Item("D");

    private ShoppingCart shoppingCart;

    @Before
    public void setUp(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void shouldReturnZero_whenCheckoutIsEmpty(){
        assertTrue(shoppingCart.checkout() == 0);
    }

    @Test
    public void shouldReturn_50_whenItem_A_checkedOut(){
        shoppingCart.addItem(A);
        assertTrue(shoppingCart.checkout() == 50);
    }

    @Test
    public void shouldReturn_30_whenItem_B_checkedOut(){
        shoppingCart.addItem(B);
        assertTrue(shoppingCart.checkout() == 30);
    }

    @Test
    public void shouldReturn_20_whenItem_C_checkedOut(){
        shoppingCart.addItem(C);
        assertTrue(shoppingCart.checkout() == 20);
    }

    @Test
    public void shouldReturn_15_whenItem_D_checkedOut(){
        shoppingCart.addItem(D);
        assertTrue(shoppingCart.checkout() == 15);
    }

    @Test
    public void shouldReturn_100_when_2_Item_A_checkedOut(){
        shoppingCart.addItem(A);
        shoppingCart.addItem(A);
        assertTrue(shoppingCart.checkout() == 100);
    }

    @Test
    public void shouldReturn_60_when_2_Item_B_checkedOut(){
        shoppingCart.addItem(B);
        shoppingCart.addItem(B);
        assertTrue(shoppingCart.checkout() == 60);
    }

    @Test
    public void shouldReturn_40_when_2_Item_C_checkedOut(){
        shoppingCart.addItem(C);
        shoppingCart.addItem(C);
        assertTrue(shoppingCart.checkout() == 40);
    }

    @Test
    public void shouldReturn_30_when_2_Item_D_checkedOut(){
        shoppingCart.addItem(D);
        shoppingCart.addItem(D);
        assertTrue(shoppingCart.checkout() == 30);
    }

//    @Test
//    public void shouldReturn_130_when_3_Item_A_checkedOut(){
//        shoppingCart.addItem(A);
//        shoppingCart.addItem(A);
//        shoppingCart.addItem(A);
//        assertTrue(shoppingCart.checkout() == 130);
//    }
}
