import java.util.Random;

public class Witch extends Adventurer{
  private int mana;
  private static final int MAX_MANA = 100;

  public Witch(String name){
    super(name, 50);
    this.mana = 50;
  }

  public Witch(String name, int hp, int mana){
    super(name, hp);
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

  public String attack(Adventurer other){
    Random rand = new Random();
    int damage = rand.nextInt(10)+5;
    other.applyDamage(damage);
    return this.getName()+" casts a spell and deals " + damage + " damage to " + other.getName();
  }

  public String support(Adventurer other){
    int healAmount = 10;
    int newHP = other.getHP() + healAmount;
    if (newHP > other.getmaxHP()){
      newHP = other.getmaxHP();
    }
    other.setHP(newHP);
    return this.getName() + " casts a healing spell on " + other.getName() + " for " + healAmount + "HP.";
  }

  public String support(){
    int healAmount = 10;
    int newHP = getHP() + healAmount;
    if (newHP > getmaxHP()){
      newHP = getmaxHP();
    }
    setHP(newHP);
    return this.getName() + " casts a healing spell on themselves for " + healAmount + " HP.";
  }

  public String specialAttack(Adventurer other){
    if (mana < 20){
      return this.getName() + " doesn't have enough mana for a special attack.";
    }
    Random rand = new Random();
    int damage = rand.nextInt(20)+15;
    other.applyDamage(damage);
    mana -= 20;
    return this.getName() + " uses a powerful spell to deal " + damage + " damage to " + other.getName() + " and consumes 20 mana.";
  }

  public String toString(){
    return this.getName() + " (Witch) - HP: " + getHP() + "/" + getmaxHP() + " | Mana: " + getSpecial() + "/" + getSpecialMax();
  }
}
