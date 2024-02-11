package Restaurant;
public class Main {
    public static void main(String[] args)
    {
        Salary waiter = new Salary(8,15,"Emily","Waitress");
        System.out.println(waiter);
        Salary chef = new Salary(10, 25, "John", "Chef" ); 
        System.out.println(chef);
        Salary HeadChef = new Salary(10, 30, "Joe", "Head Chef"); 
        System.out.println(HeadChef);
        Salary Manager = new Salary(10, 35.50, "Bob", "Manager"); 
        System.out.println(Manager);
        Supply supply = new Supply();

        // Add supplies with quantities and prices
        supply.addSupply("Apple", 50, 1.0);
        supply.addSupply("Banana", 30, 0.5);
        supply.addSupply("Orange", 40, 0.75);

        // Display the initial supplies
        System.out.println("Initial Supplies:");
        System.out.println(supply);

        // Create an Orders object
        Orders orders = new Orders(supply);

        // Place orders
        orders.placeOrder("Apple", 10);
        orders.placeOrder("Banana", 20);
        orders.placeOrder("Orange", 15);

        // Display the orders
        System.out.println("Current Orders:");
        System.out.println(orders);

        // Remove some items from the order
        orders.removeFromOrder("Apple", 5);
        orders.removeFromOrder("Banana", 10);

        // Display the updated orders
        System.out.println("Updated Orders:");
        System.out.println(orders);

        // Process orders
        orders.processOrders();

        // Display the final supplies after processing orders
        System.out.println("Final Supplies:");
        System.out.println(supply);
        System.out.println("The total cost is");
        System.out.println(orders.getOrderTotal());
        supply.displayMenu();
    }
}
