/*
My name is Ibrahim
toString() is automatically run in main when trying to print the object
Printing an object will only print an address if a toString() function does not exist within the class of the object
*/
public class Kitty {
    private int age;
    private String name;
    public Kitty(String setName, int setAge){
        age = setAge;
        name = setName;
    }
    public Kitty(){
        this("Mittens", 2);
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void makeOlder(){
        age++;
    }
    public void changeName(String newName){
        name = newName;
    }
    public void changeAge(int newAge){
        age = newAge;
    }
    public String toString(){
        return "The amazing " + getName();
    }
}
