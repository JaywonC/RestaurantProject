package Restaurant;
import java.util.ArrayList;
import java.util.List;

public class Supply {
    private List<String> items;
    private List<Double> prices;
    private List<Integer> quantities;
//Creates all the lists
    public Supply() {
        this.items = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }
//Prints out the supplies in menu format for customers
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + ": $" + prices.get(i));
        }
    }
//Adds the supply to the supplies lists
    public void addSupply(String item, int quantity, double price) {
        int index = items.indexOf(item);
        if (index != -1) {
            quantities.set(index, quantities.get(index) + quantity);
        } else {
            items.add(item);
            prices.add(price);
            quantities.add(quantity);
        }
    }
    //Removes a certain item from the list, along with a specific quantity
    public boolean removeSupply(String item, int quantity) {
        int index = items.indexOf(item);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            if (currentQuantity >= quantity) {
                quantities.set(index, currentQuantity - quantity);
                return true;
            } else {
                System.out.println("Not enough " + item + " in stock.");
                return false;
            }
        } else {
            System.out.println(item + " not found in supplies.");
            return false;
        }
    }
//Checks the list to see if the item is present returns the quantity of the said item if it is available 
    public Integer checkSupply(String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return quantities.get(i);
            }
        }
        System.out.println(item + " not found in supplies.");
        return null;
    }
    //Gets the price of a certain item
    public Double getItemPrice(String item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return prices.get(index);
        } else {
            System.out.println(item + " not found in supplies.");
            return null;
        }
    }
    //To string method pritns out the details of all the supplies
    public String toString(){
        String result = "Supply{items=";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i) + ": " + quantities.get(i) + " (Price: $" + prices.get(i) + "), ";
        }
        if (!items.isEmpty()) {
            result = result.substring(0, result.length() - 2);  // Remove the comma and space after
        }
        result += "}";
        return result;
    }

}


