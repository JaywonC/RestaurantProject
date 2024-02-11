package Restaurant;
public class Salary {
    private double salary;
    private int hours;
    private String name;
    private String position;
    

public Salary(){
    salary = 15;
    hours = 8;

}
public Salary(int h, double s,String n, String p){
    salary = s;
    hours = h;
    name = n;
    position = p;
}
public double getSalary(){
    return salary;
}
public int getHours(){
    return hours;
}
public String getName(){
    return name;
}
public String getPosition(){
    return position;
}
public void setSalary(double s){
    salary = s;
}
public void setHours(int h){
    hours  = h;
}
public void setName(String n){
    name =n;
}
public void setPosition(String p){
    position =p;
}
public String toString(){
    return "\nName: " + name + "\nPosition: " + position + "\nSalary: " + "$" +salary +"/hour"+ "\nHours worked: " +hours;
}
}