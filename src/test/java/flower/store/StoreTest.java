package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StoreTest {
    private Store store;

    @BeforeEach
    public void setUp() {
        store = new Store();
        
        store.addFlowerPack(new FlowerPack(new Chamomile(5.0, FlowerColor.YELLOW, 1.5), 10));
        store.addFlowerPack(new FlowerPack(new Rose(6.0, FlowerColor.RED, 2.0), 5));
        store.addFlowerPack(new FlowerPack(new Tulip(7.0, FlowerColor.BLUE, 1.8), 3));
        store.addFlowerPack(new FlowerPack(new Chamomile(4.0, FlowerColor.WHITE, 1.2), 7));
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
        List<FlowerPack> results = store.search(null, null, 1.5, 2.0);
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByAllCriteria() {
        List<FlowerPack> results = store.search(FlowerType.ROSE, FlowerColor.RED, 1.5, 2.5);
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchNoResults() {
        List<FlowerPack> results = store.search(FlowerType.TULIP, FlowerColor.WHITE, null, null);
        assertEquals(0, results.size());
    }
}
