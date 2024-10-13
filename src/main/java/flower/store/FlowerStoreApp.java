package flower.store;

public class FlowerStoreApp {
    public static void main(String[] args) {
        // Create instances of your Flower and FlowerPack classes
        Flower flower1 = new Flower(12.99, FlowerColor.RED, 2.0, FlowerType.ROSE);
        Flower flower2 = new Flower(15.49, FlowerColor.BLUE, 1.5, FlowerType.TULIP);
        
        FlowerPack flowerPack = new FlowerPack(flower1, 3); // Assuming this constructor exists

        // Display information about the flowers and the pack
        System.out.println("Flower 1: " + flower1.getColor() + " " + flower1.getType() + " at " + flower1.getPrice());
        System.out.println("Flower 2: " + flower2.getColor() + " " + flower2.getType() + " at " + flower2.getPrice());
        System.out.println("Flower Pack contains " + flowerPack.getFlower().getColor() + " flowers, quantity: " + flowerPack.getQuantity());
    }
}
