package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private static final double PRICE_ONE = 5.0;
    private static final double DISCOUNT_ONE = 1.5;
    private static final int QUANTITY_ONE = 10;

    private static final double PRICE_TWO = 6.0;
    private static final double DISCOUNT_TWO = 5.0; 
    private static final double PRICE_THREE = 7.0;
    private static final double DISCOUNT_THREE = 1.8;
    private static final int QUANTITY_TWO = 3;
    private static final double PRICE_FOUR = 4.0;
    private static final double DISCOUNT_FOUR = 1.2;
    private static final int QUANTITY_THREE = 7;
    private static final double EXPECTED_TOTAL = 15.5;
    private static final double TEST_DISCOUNT = 1.5;
    private static final double TEST_PRICE_LIMIT = 2.5;

    private Store store;

    @BeforeEach
    public void setUp() {
        store = new Store();
        store.addFlowerPack(new FlowerPack(new Chamomile(PRICE_ONE, FlowerColor.YELLOW, DISCOUNT_ONE), QUANTITY_ONE));
        store.addFlowerPack(new FlowerPack(new Rose(PRICE_TWO, FlowerColor.RED, DISCOUNT_TWO), 5));
        store.addFlowerPack(new FlowerPack(new Tulip(PRICE_THREE, FlowerColor.BLUE, DISCOUNT_THREE), QUANTITY_TWO));
        store.addFlowerPack(new FlowerPack(new Chamomile(PRICE_FOUR, FlowerColor.WHITE, DISCOUNT_FOUR), QUANTITY_THREE));
    }

    @Test
    public void testStoreFunctionality() {
        double total = (PRICE_ONE * QUANTITY_ONE) - DISCOUNT_ONE + (PRICE_TWO * 2) - DISCOUNT_TWO;
        assertEquals(EXPECTED_TOTAL, total);
    }

    @Test
    public void testSearchByType() {
        List<FlowerPack> results = store.search(FlowerType.CHAMOMILE, null, null, null);
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByColor() {
        List<FlowerPack> results = store.search(null, FlowerColor.RED, null, null);
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchByPriceRange() {
        List<FlowerPack> results = store.search(null, null, TEST_DISCOUNT, 2.0); // Using TEST_DISCOUNT instead of magic number
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByAllCriteria() {
        List<FlowerPack> results = store.search(FlowerType.ROSE, FlowerColor.RED, TEST_DISCOUNT, TEST_PRICE_LIMIT); // Using constants
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchNoResults() {
        List<FlowerPack> results = store.search(FlowerType.TULIP, FlowerColor.WHITE, null, null);
        assertEquals(0, results.size());
    }
}
