import main.Discount;
import main.Item;
import main.PriceHolder;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PriceHolderTest {

    private Map<Item, Integer> normalPrices = new HashMap<>();
    private Map<Item, Discount> discountPrices = new HashMap<>();

    @Test
    public void shouldSetAndRetrievePricesProperly(){
        PriceHolder.updatePrices(normalPrices, discountPrices);

        assertTrue(PriceHolder.getNormalPrices().equals(normalPrices));
        assertTrue(PriceHolder.getDiscountPrices().equals(discountPrices));
    }
}