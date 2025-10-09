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
}
