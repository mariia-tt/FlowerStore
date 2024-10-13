package flower.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<FlowerPack> flowers;

    public Store() {
        this.flowers = new ArrayList<>();
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowers.add(flowerPack);
    }

    public List<FlowerPack> search(FlowerType type, FlowerColor color,
     Double minPrice, Double maxPrice) {
        return flowers.stream()
                .filter(pack -> (type == null
 || pack.getFlower().getFlowerType() == type) && (color == null
  || pack.getFlower().getColor().equals(color.toString())) && (minPrice
   == null || pack.getPrice() >= minPrice) && (maxPrice == null
    || pack.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }
}
