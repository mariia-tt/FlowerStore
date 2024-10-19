package flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    private double price;
    @Getter
    private FlowerType flowerType;

    

    public Flower(double sepalLength, FlowerColor flowerColor,
     double flowerPrice, FlowerType flowerType) {
        this.sepalLength = sepalLength;
        this.color = flowerColor;
        this.price = flowerPrice;
        this.flowerType = flowerType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public FlowerType getFlowerType() {
        return this.flowerType;
    }

    public FlowerColor getColor() {
        return this.color;
    }
}