package Restaurant;
public class Salary {
    private double salary;
    private int hours;
    private String name;
    private String position;
    

public Salary(){
    salary = 15;
    hours = 8;

}//Constructor for the class
public Salary(int h, double s,String n, String p){
    salary = s;
    hours = h;
    name = n;
    position = p;
}
//Gets teh salary
public double getSalary(){
    return salary;
}
//Gets the hours
public int getHours(){
    return hours;
}
//Gets the name of the employee
public String getName(){
    return name;
}
//Gets the position of the employee
public String getPosition(){
    return position;
}
//Sets the salary of the employee
public void setSalary(double s){
    salary = s;
}
//Sets the hours of the employee
public void setHours(int h){
    hours  = h;
}
//Sets the name of the employee
public void setName(String n){
    name =n;
}
//Sets the position of the employee
public void setPosition(String p){
    position =p;
}
public String toString(){
    return "\nName: " + name + "\nPosition: " + position + "\nSalary: " + "$" +salary +"/hour"+ "\nHours worked: " +hours;
}
}