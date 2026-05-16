public class Player{
  public int money;
  public int position;
  public ArrayList<Property> ownedProperties = new ArrayList<Property>();
  public String name;

  public Player(String name) {
  this.name = name;
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
    money -= p.price;
    ownedProperties.add(p);
    p.owner = this;
  }

  public boolean checkBankrupt(){
    return money < 0;
  }

}
