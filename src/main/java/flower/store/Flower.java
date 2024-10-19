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

    

    public Flower(double sepalLength, FlowerColor color, double price,
     FlowerType flowerType) {
        this.sepalLength = sepalLength;
        this.color = color;
        this.price = price;
        this.flowerType = flowerType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color.toString();
    }
}