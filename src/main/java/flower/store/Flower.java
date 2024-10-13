package flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
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

    public String getColor() {
        return color.toString();
    }
}

class CHAMOMILE extends Flower{
    public CHAMOMILE(double sepalLength, FlowerColor color,
     double price) {
        super(sepalLength, color, price, FlowerType.CHAMOMILE);
    }
}

class ROSE extends Flower{
    public ROSE(double sepalLength, FlowerColor color,
     double price) {
        super(sepalLength, color, price, FlowerType.ROSE);
    }
}

class TULIP extends Flower{
    public TULIP(double sepalLength, FlowerColor color,
     double price) {
        super(sepalLength, color, price, FlowerType.TULIP);
    }
}

