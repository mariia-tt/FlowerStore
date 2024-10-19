package flower.store;

import lombok.Getter;

public class FlowerPack {
    @Getter
    private Flower flower;
    @Getter
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return this.flower.getPrice() * this.quantity;
    }
}
