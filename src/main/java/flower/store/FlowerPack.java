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

    public Flower getFlower() {
        return flower;
        
    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return this.flower.getPrice() * this.quantity;
    }
}
