import java.util.*;
public class Supply{// be able to add food and remove food, how much food, object
    private List<String> foods;// ArrayList: Holds different types of foods
    // ArrayList: Holds the number of foods  
public Supply(){
    foods = new ArrayList<>();
}
public void addFood(String food){
    foods.add(food);
}
public void removeFood(String remove){
    for(int i = foods.size()-1; i>=0; i++){
        if(foods.get(i).equals(remove)){
            foods.remove(i);
        }
    }

}
public static boolean findFood(String food){
    for (int i = 0; i < foods.size(); i++){
        if(foods.get(i).equals(food)){
            foods.remove(i);
            return true;
        }
    }
    return false;
}
public void display(){
    System.out.println("Food List: ");
    for(String food: foods){
        System.out.println(food);
    }
    System.out.println("Max amount of storage:100 \nAmount of space used " + foods.size() + "/100");
}
}