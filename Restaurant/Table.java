package Restaurant;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static List<Table> tables = new ArrayList<>();
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;
//Constructor for the table
    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
        tables.add(this);
        //Adds the table to the arraylist
    }

//Prints out all the tables
    public static void displayAllTables() {
        System.out.println("All Tables:");
        for (Table table : tables) {
            System.out.println(table);
        }
    }
//Algorithm for finding the biggest table
    public static Table findLargest() {
        if (tables.isEmpty()) {
            System.out.println("No tables available.");
            return null;
        }

        Table largestTable = tables.get(0);

        for (int i = 1; i < tables.size(); i++) {
            if (tables.get(i).getCapacity() > largestTable.getCapacity()) {
                largestTable = tables.get(i);
            }
        }

        return largestTable;
    }
//Algorithm for finding the smallest table
    public static Table findSmallest() {
        Table smallestTable = tables.get(0);
        for (int i = 1; i < tables.size(); i++) {
            if (tables.get(i).getCapacity() < smallestTable.getCapacity()) {
                smallestTable = tables.get(i);
            }
        }

        return smallestTable;
    }
//Gets the tableNumber
    public int getTableNumber() {
        return tableNumber;
    }
//Gets the capacity of the table
    public int getCapacity() {
        return capacity;
    }
//Returns true or false, checks if the table is occupied
    public boolean isOccupied() {
        return isOccupied;
    }
//Occupies the table
    public void occupyTable() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Table " + tableNumber + " is now occupied.");
        } else {
            System.out.println("Table " + tableNumber + " is already occupied.");
        }
    }
//Vacates the table
    public void vacateTable() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Table " + tableNumber + " is now vacant.");
        } else {
            System.out.println("Table " + tableNumber + " is already vacant.");
        }
    }
//String to string method
    public String toString() {
        return "Table " + tableNumber + " (Capacity: " + capacity + ")";
    }
}
