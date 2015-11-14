import main.Item;
import main.PriceCalculator;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PriceCalculatorTest {
    public static final Item A = new Item("A");
    public static final Item B = new Item("B");
    private PriceCalculator priceCalculator = new PriceCalculator(getNormalPrices());

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

    private Map<Item, Integer> getNormalPrices(){
        Map<Item,Integer> itemPrices = new HashMap<>();
        itemPrices.put(A, 50);
        itemPrices.put(B, 30);
        return itemPrices;
    }
}