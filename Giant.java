import java.util.*;

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
  public String attack(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    other.applyDamage(50);
    this.applyDamage(20);
    return getName() + " punched " + other.getName() + " and gave them a concussion " + other.getName() + " lost 50 HP. " + getName() + " lost 20 HP.";
  }

  public String support(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    if (getSpecial() < 5){
      return support();
    }
    int restoreAmt = (int)(other.getSpecialMax()/3);
    if (restoreAmt > other.getSpecialMax() - other.getSpecial()){
      restoreAmt = other.getSpecialMax() - other.getSpecial();
    }
    other.restoreSpecial(restoreAmt);
    Cows -= 5;
    return getName() + " compressed 5 cows and turned it into " + other.getSpecialName() + " for " + other.getName() + ". " + other.getName() + " gained " + restoreAmt + " " + other.getSpecialName() + ". " + getName() + " lost five cows.";
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
  public String specialAttack(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    if (getSpecial() < 5){
      return attack(others, index);
    }
    setSpecial(getSpecial() - 5);
    other.applyDamage(70);
    for (int i=0;i<others.size();i++){
      if (i != index){
        others.get(i).applyDamage(10);
      }
    }
    return getName() + " ate 5 cows and threw a tantrum on top of " + other.getName() + " and their all(ies). Their all(ies) lost 10 HP. " + other.getName() + " lost 70 HP. " + getName() + " lost 5 cows.";
  }
}
