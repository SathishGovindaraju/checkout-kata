import main.Discount;
import main.Item;
import main.ItemA;
import main.PriceHolder;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PriceHolderTest {

    private Map<Item, Integer> normalPrices = new HashMap<>();
    private Map<Item, Discount> discountPrices = new HashMap<>();

    @Test
    public void shouldNeverReturn_Null_prices(){
        assertTrue(PriceHolder.getNormalPrices() != null);
        assertTrue(PriceHolder.getDiscountPrices() != null);
    }

    @Test
    public void shouldSetAndRetrievePricesProperly(){
        normalPrices.put(new ItemA(), 1);
        discountPrices.put(new ItemA(), new Discount(2,30));

        PriceHolder.updatePrices(normalPrices, discountPrices);

        assertTrue(PriceHolder.getNormalPrices().equals(normalPrices));
        assertTrue(PriceHolder.getDiscountPrices().equals(discountPrices));
    }

}