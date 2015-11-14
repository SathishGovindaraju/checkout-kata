import main.*;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PriceCalculatorTest {
    public static final Item A = new ItemA();
    public static final Item B = new ItemB();
    public static final Item C = new ItemC();
    private PriceCalculator priceCalculator = new PriceCalculator(getNormalPrices(), getDiscountPrices());

    @Test
    public void shouldReturn_0_whenNoItems(){
        assertTrue(priceCalculator.calculatePriceForItems(new HashMap<>()) == 0);
    }

    @Test
    public void shouldReturn_50_whenListHasItem_A(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 1);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 50);
    }

    @Test
    public void shouldReturn_100_whenListHas_2_Item_A(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 2);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 100);
    }

    @Test
    public void shouldReturn_80_whenListHasItem_A_B(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 1);
        items.put(B, 1);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 80);
    }

    @Test
    public void shouldReturn_130_whenListHasItem_A_A_A(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 3);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 130);
    }

    @Test
    public void shouldReturn_180_whenListHasItem_A_A_A_A(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 4);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 180);
    }

    @Test
    public void shouldReturn_225_whenListHasItem_A_A_A_A_B_B(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 4);
        items.put(B, 2);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 225);
    }

    @Test
    public void shouldReturn_245_whenListHasItem_A_A_A_A_B_B_C(){
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(A, 4);
        items.put(B, 2);
        items.put(C, 1);
        assertTrue(priceCalculator.calculatePriceForItems(items) == 245);
    }

    private Map<Item, Integer> getNormalPrices(){
        Map<Item,Integer> normalItemPrices = new HashMap<>();
        normalItemPrices.put(A, 50);
        normalItemPrices.put(B, 30);
        normalItemPrices.put(C, 20);
        return normalItemPrices;
    }

    private Map<Item, Discount> getDiscountPrices() {
        Map<Item, Discount> discountedItemPrices = new HashMap<>();
        discountedItemPrices.put(A, new Discount(3,130));
        discountedItemPrices.put(B, new Discount(2,45));
        return discountedItemPrices;
    }
}