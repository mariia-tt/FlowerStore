package flower.store;

import java.util.ArrayList; 

public class FlowerBucket {
    private ArrayList<FlowerPack> flowerBucket_list;

    public FlowerBucket() {
        this.flowerBucket_list = new ArrayList<>();
    }

    public void add(FlowerPack flowerPack) {
        this.flowerBucket_list.add(flowerPack);
    }

    public FlowerBucket (ArrayList<FlowerPack> FlowerBucket_list) {
        this.flowerBucket_list = FlowerBucket_list;
    }

    public double getPrice() {
        double sum = 0;
        int l = flowerBucket_list.size();
        for (int i = 0; i < l; i++) {
            FlowerPack pack = flowerBucket_list.get(i);
            sum += pack.getPrice();
        }
        return sum;
    }
}
