package test;

import main.ShoppingCart;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ShoppingCartTest {

    @Test
    public void shouldReturnZero_whenCheckoutIsEmpty(){
        ShoppingCart shoppingCart = new ShoppingCart();
        assertTrue(shoppingCart.checkout() == 0);
    }

    @Test
    public void shouldReturn_50_whenItem_A_checkedOut(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("A");
        assertTrue(shoppingCart.checkout() == 50);
    }

    @Test
    public void shouldReturn_30_whenItem_B_checkedOut(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("B");
        assertTrue(shoppingCart.checkout() == 30);
    }

    @Test
    public void shouldReturn_20_whenItem_C_checkedOut(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("C");
        assertTrue(shoppingCart.checkout() == 20);
    }

    @Test
    public void shouldReturn_15_whenItem_D_checkedOut(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("D");
        assertTrue(shoppingCart.checkout() == 15);
    }
}
