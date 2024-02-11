package Restaurant;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<String> orderedItems;
    private List<Integer> orderedQuantities;
    private List<Double> orderedPrices;
    private Supply supply;

    public Orders(Supply supply) {
        this.orderedItems = new ArrayList<>();
        this.orderedQuantities = new ArrayList<>();
        this.orderedPrices = new ArrayList<>();
        this.supply = supply;
    }

    public void placeOrder(String item, int quantity) {
        Integer availableQuantity = supply.checkSupply(item);
        Double itemPrice = supply.getItemPrice(item);

        if (availableQuantity != null && availableQuantity >= quantity) {
            int existingIndex = orderedItems.indexOf(item);
            if (existingIndex != -1) {
                int existingQuantity = orderedQuantities.get(existingIndex);
                orderedQuantities.set(existingIndex, existingQuantity + quantity);
            } else {
                orderedItems.add(item);
                orderedQuantities.add(quantity);
                orderedPrices.add(itemPrice);
            }
            System.out.println("Order placed for " + quantity + " " + item + "(s).");
        } else {
            System.out.println("Cannot place order. Not enough " + item + " in stock");
        }
    }

    public void removeFromOrder(String item, int quantity) {
        int existingIndex = orderedItems.indexOf(item);

        if (existingIndex != -1) {
            int existingQuantity = orderedQuantities.get(existingIndex);
            if (existingQuantity >= quantity) {
                orderedQuantities.set(existingIndex, existingQuantity - quantity);
                System.out.println("Removed " + quantity + " " + item + "(s) from the order.");
            } else {
                System.out.println("Not enough " + item + " in the order.");
            }
        } else {
            System.out.println(item + " not found in the order.");
        }
    }

    public int getOrderTotal() {
        int total = 0;

        for (int i = 0; i < orderedItems.size(); i++) {
            int quantityOrdered = orderedQuantities.get(i);
            double itemPrice = orderedPrices.get(i);
            total += quantityOrdered * itemPrice;
        }

        return total;
    }

    public void processOrders() {
        System.out.println("Processing Orders:");

        for (int i = 0; i < orderedItems.size(); i++) {
            String item = orderedItems.get(i);
            int quantityOrdered = orderedQuantities.get(i);
            double itemPrice = orderedPrices.get(i);

            boolean success = supply.removeSupply(item, quantityOrdered);

            if (success) {
                System.out.println("Order processed for " + quantityOrdered + " " + item + "(s) at $" + itemPrice + " each.");
            } else {
                System.out.println("Failed to process order for " + quantityOrdered + " " + item + "(s).");
            }
        }

    }
    public String toString() {
        String result = "Orders{";
        for (int i = 0; i < orderedItems.size(); i++) {
            result += orderedItems.get(i) + ": " + orderedQuantities.get(i) + " (Price: $" + orderedPrices.get(i) + "), ";
        }
        if (!orderedItems.isEmpty()) {
            result = result.substring(0, result.length() - 2);  // Remove the comma and space
        }
        result += "}";
        return result;
    } 
}
