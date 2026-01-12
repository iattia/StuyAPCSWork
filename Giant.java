public class Giant extends Adventurer{
  private int Cows, maxCows = 10;
  private String name;

  public Giant(String name){
    super(name);
    super.setName(name + " the Giant");
    super.setHP(120);
    super.setmaxHP(120);
    setSpecial(5);
  }


  //special
  public String getSpecialName(){
    return "cows";
  }
  public int getSpecial(){
    return Cows;
  }
  public void setSpecial(int n){
    Cows = n;
  }
  public int getSpecialMax(){
    return maxCows;
  }

  //attack & support
  public String attack(Adventurer other){
    other.applyDamage(50);
    this.applyDamage(20);
    return getName() + " headbutted " + other.getName() + " and got a concussion. " + other.getName() + " lost 50 HP. " + getName() + " lost 20 HP.";
  }

  public String support(Adventurer other){
    if (getSpecial() - 5 < 0){
      support();
    }
    int restoreAmt = (int)(other.getSpecialMax()/3);
    if (restoreAmt > other.getSpecialMax() - other.getSpecial()){
      restoreAmt = other.getSpecialMax() - other.getSpecial();
    }
    other.restoreSpecial(restoreAmt);
    Cows -= 5;
    return getName() + " compressed 5 cow and turned it into " + other.getSpecialName() + " for " + other.getName() + ". " + other.getName() + " gained " + restoreAmt + " " + other.getSpecialName() + ". " + getName() + " lost five cows.";
  }

  //heall or buff self
  public String support(){
    int restoreAmt = 35;
    if (restoreAmt > getmaxHP() - getHP()){
      restoreAmt = getmaxHP() - getHP();
    }
    setHP(getHP() + restoreAmt);
    int restoreSPAmt = 2;
    if (restoreSPAmt > getSpecialMax() - getSpecial()){
      restoreSPAmt = getSpecialMax() - getSpecial();
    }
    restoreSpecial(restoreSPAmt);
    return getName() + " rolled around in some mud. " + getName() + " gained " + restoreAmt + " HP and " + restoreSPAmt + " " + getSpecialName();
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    if (getSpecial() - 5 < 0){
      attack(other);
    }
    setSpecial(getSpecial() - 5);
    other.applyDamage(70);
    return getName() + " ate 5 cows and threw a tantrum on top of " + other.getName() + ". " + other.getName() + " lost 70 HP. " + getName() + " lost 5 cows.";
  }
}
