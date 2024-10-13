package flower.store;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Store {
    private List<FlowerBucket> flowerBuckets;

    public Store() {
        this.flowerBuckets = new ArrayList<>();
    }

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        this.flowerBuckets.add(flowerBucket);
    }

    public List<Flower> search(FlowerType flowerType, FlowerColor color,
     Double minSepalLength, Double maxSepalLength, Double minPrice,
      Double maxPrice) {
        List<Flower> result = new ArrayList<>();

        for (FlowerBucket bucket : flowerBuckets) {
            for (FlowerPack flowerPack : bucket.getflowerBucket_list()) {
                for (Flower flower : flowerPack.getFlower()) {
                    if (matchesCriteria(flower, flowerType, color,
                     minSepalLength, maxSepalLength, minPrice, maxPrice)) {
                        result.add(flower);
                    }
                }
            }
        }
        return result;
    }

    private boolean matchesCriteria(Flower flower, FlowerType flowerType, FlowerColor color,
     Double minSepalLength, Double maxSepalLength, Double minPrice, Double maxPrice) {
        boolean matches = true;

        if (flowerType == null && !flower.getFlowerType().equals(flowerType)
         || color != null && !flower.getColor().equals(color.toString())
         || minSepalLength != null && flower.getSepalLength() < minSepalLength
         || maxSepalLength != null && flower.getSepalLength() > maxSepalLengt
         || minPrice != null && flower.getPrice() < minPrice
         || maxPrice != null && flower.getPrice() > maxPrice) {
            matches = false;
        }

        return matches;
    }
}
