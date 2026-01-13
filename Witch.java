import java.util.*;

public class Witch extends Adventurer{
  private int mana;
  private static final int MAX_MANA = 100;

  public Witch(String name){
    super(name, 50);
    super.setName(name + " the Witch");
    super.setmaxHP(50);
    this.mana = 50;
  }

  public Witch(String name, int hp, int mana){
    super(name, hp);
    super.setmaxHP(hp);
    this.mana = mana;
  }

  public String getSpecialName(){
    return "Mana";
  }

  public int getSpecial(){
    return mana;
  }

  public void setSpecial(int n){
    if (n > MAX_MANA){
      mana = MAX_MANA;
    } else if (n<0){
      mana = 0;
    } else{
      mana = n;
    }
  }

  public int getSpecialMax(){
    return MAX_MANA;
  }

  public String attack(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    Random rand = new Random();
    int damage = rand.nextInt(10)+5;
    other.applyDamage(damage);
    return this.getName()+" casts a spell and deals " + damage + " damage to " + other.getName();
  }

  public String support(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    int healAmount = (int)(other.getmaxHP() * 0.1);
    int newHP = other.getHP() + healAmount;
    if (newHP > other.getmaxHP()){
      newHP = other.getmaxHP();
      healAmount = other.getmaxHP() - other.getHP();
    }
    other.setHP(newHP);
    return this.getName() + " casts a healing spell on " + other.getName() + " for " + healAmount + "HP.";
  }

  public String support(){
    int healAmount = 10;
    int newHP = getHP() + healAmount;
    if (newHP > getmaxHP()){
      newHP = getmaxHP();
      healAmount = getmaxHP() - getHP();
    }
    setHP(newHP);
    return this.getName() + " casts a healing spell on themselves for " + healAmount + " HP.";
  }

  public String specialAttack(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    if (mana < 20){
      return this.getName() + " doesn't have enough mana for a special attack!" + attack(others, index);
    }
    Random rand = new Random();
    int damage = rand.nextInt(20)+25;
    other.applyDamage(damage);
    mana -= 20;
    return this.getName() + " casts a powerful dense spell dealing " + damage + " damage to " + other.getName() + " and consumes 20 mana.";
  }

  public String toString(){
    return this.getName() + " - HP: " + getHP() + "/" + getmaxHP() + " | Mana: " + getSpecial() + "/" + getSpecialMax();
  }
}
