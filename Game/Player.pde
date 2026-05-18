public class Player{
  public String name;
  public int money;
  public int position;
  public ArrayList<Property> ownedProperties = new ArrayList<Property>();
  public color playerColor;

public Player(String name, color playerColor) {
  this.name = name;
  this.playerColor = playerColor;
  this.money = 1500;
  this.position = 0;
  this.ownedProperties = new ArrayList<Property>();
}
  public void move(int steps) {
    position += steps;
    if (position >= 40) {
      position = position % 40;
      if (position != 0) {
        money += 200; // this is when you pass go without landing on it
      }
    }
  }


  public void pay(int amount, Player p){
    money -= amount;
    p.money += amount;
  }
  public void buyProperty(Property p){
    if (p.owner == null) {
      money -= p.price;
     ownedProperties.add(p);
      p.owner = this;
      System.out.println(name + " now owns " + p.name + ". The rent is $" + p.rent );
    } else {
      println(p.name + " is already owned by " + p.owner.name);
    }

  }

  public boolean checkBankrupt(){
    return money < 0;
  }

}
