package Restaurant;
public class Main {
    public static void main(String[] args)
    {
        Salary Manager = new Salary(10, 35.50, "Bob", "Manager"); 
        System.out.println(Manager);
        Supply supply = new Supply();

        // Add supplies to the menu
        supply.addSupply("Burger", 10, 5.99);
        supply.addSupply("Pizza", 15, 8.99);
        supply.addSupply("Salad", 20, 4.99);

        // Display the menu
        supply.displayMenu();

        // Create tables
        Table table1 = new Table(1, 4);
        Table table2 = new Table(2, 6);

        // Display all tables
        Table.displayAllTables();

        // Find the largest and smallest tables
        Table largestTable = Table.findLargest();
        System.out.println("Largest Table: " + largestTable);

        Table smallestTable = Table.findSmallest();
        System.out.println("Smallest Table: " + smallestTable);

        // Place orders for the tables
        Orders ordersTable1 = new Orders(supply);
        Orders ordersTable2 = new Orders(supply);

        ordersTable1.placeOrder("Burger", 2);
        ordersTable1.placeOrder("Pizza", 1);

        ordersTable2.placeOrder("Salad", 3);

        // Display the orders
        System.out.println("Order for Table 1: " + ordersTable1);
        System.out.println("Order for Table 2: " + ordersTable2);

        // Process the orders
        ordersTable1.processOrders();
        ordersTable2.processOrders();

        // Check supply quantity for an item
        Integer burgerQuantity = supply.checkSupply("Burger");
        System.out.println("Quantity of Burgers in supply: " + burgerQuantity);

        // Display updated supplies and table status
        System.out.println("Updated Supplies: " + supply);
        System.out.println("Table " + table1.getTableNumber() + " Status: Occupied - " + table1.isOccupied());
        System.out.println("Table " + table2.getTableNumber() + " Status: Occupied - " + table2.isOccupied());

        // Vacate the tables
        table1.vacateTable();
        table2.vacateTable();

        // Display updated table status
        System.out.println("Table " + table1.getTableNumber() + " Status: Occupied - " + table1.isOccupied());
        System.out.println("Table " + table2.getTableNumber() + " Status: Occupied - " + table2.isOccupied());
    }
}

