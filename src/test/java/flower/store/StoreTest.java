package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private static final double PRICE_ONE = 5.0;
    private static final double DISCOUNT_ONE = 1.5;
    private static final double QUANTITY_ONE = 10;

    private static final double PRICE_TWO = 6.0;
    private static final double DISCOUNT_TWO = 5.0;

    private Store store;

    @BeforeEach
    public void setUp() {
        store = new Store();
        store.addFlowerPack(new FlowerPack(new Chamomile(PRICE_ONE,
         FlowerColor.YELLOW, DISCOUNT_ONE), (int) QUANTITY_ONE));
        store.addFlowerPack(new FlowerPack(new Rose(PRICE_TWO,
         FlowerColor.RED, 2.0), 5));
        store.addFlowerPack(new FlowerPack(new Tulip(7.0,
         FlowerColor.BLUE, 1.8), 3));
        store.addFlowerPack(new FlowerPack(new Chamomile(4.0,
         FlowerColor.WHITE, 1.2), 7));
    }

    @Test
    public void testStoreFunctionality() {
        double total = (PRICE_ONE * QUANTITY_ONE) - DISCOUNT_ONE
         + (PRICE_TWO * 2) - DISCOUNT_TWO;
        assertEquals(15.5, total);
    }

    @Test
    public void testSearchByType() {
        List<FlowerPack> results = store.search(FlowerType.CHAMOMILE,
         null, null, null);
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByColor() {
        List<FlowerPack> results = store.search(null,
         FlowerColor.RED, null, null);
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchByPriceRange() {
        List<FlowerPack> results = store.search(null,
         null, 1.5, 2.0);
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByAllCriteria() {
        List<FlowerPack> results = store.search(FlowerType.ROSE,
         FlowerColor.RED, 1.5, 2.5);
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchNoResults() {
        List<FlowerPack> results = store.search(FlowerType.TULIP,
         FlowerColor.WHITE, null, null);
        assertEquals(0, results.size());
    }
}
