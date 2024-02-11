package Restaurant;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<String> orderedItems;
    private List<Integer> orderedQuantities;
    private List<Double> orderedPrices;
    private Supply supply;
    //The orders class makes use of the supplies class
    public Orders(Supply supply) {
        this.orderedItems = new ArrayList<>();
        this.orderedQuantities = new ArrayList<>();
        this.orderedPrices = new ArrayList<>();
        this.supply = supply;
    }
    //Method to place an order
    public void placeOrder(String item, int quantity) {
        Integer availableQuantity = supply.checkSupply(item);
        Double itemPrice = supply.getItemPrice(item);
        //Checks the supplies class to see if the said item is available
        if (availableQuantity != null && availableQuantity >= quantity) {
            //If not true than places the order
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
    // Class to remove something from your order
    public void removeFromOrder(String item, int quantity) {
        int existingIndex = orderedItems.indexOf(item);
        //checks to see if the item is in the order
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
    //Gets the total price of the order, basically a bill
    public int getOrderTotal() {
        int total = 0;

        for (int i = 0; i < orderedItems.size(); i++) {
            int quantityOrdered = orderedQuantities.get(i);
            double itemPrice = orderedPrices.get(i);
            total += quantityOrdered * itemPrice;
        }

        return total;
    }
    //this class executes the order
    // After the order is "processed" you can't remove items from that order
    public void processOrders() {
        System.out.println("Processing Orders:");

        for (int i = 0; i < orderedItems.size(); i++) {
            String item = orderedItems.get(i);
            int quantityOrdered = orderedQuantities.get(i);
            double itemPrice = orderedPrices.get(i);
            //Updates the supplies class
            boolean success = supply.removeSupply(item, quantityOrdered);
            //Tells you if the order is sucessfully processed.
            if (success) {
                System.out.println("Order processed for " + quantityOrdered + " " + item + "(s) at $" + itemPrice + " each.");
            } else {
                System.out.println("Failed to process order for " + quantityOrdered + " " + item + "(s).");
            }
        }

    }
    //Tostring method , prints out your entire order
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
