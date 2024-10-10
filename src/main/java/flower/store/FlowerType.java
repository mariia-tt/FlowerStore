package flower.store;

public enum FlowerType {
    CHAMOMILE, ROSE, TULIP;
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