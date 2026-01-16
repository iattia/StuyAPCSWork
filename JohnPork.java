import java.util.*;

public class JohnPork extends Adventurer{
  private int waves;
  private static final int MAX_WAVES = 100;

  public JohnPork(String name){
    super(name, 50);
    super.setName(name + " [BOSS]");
    super.setmaxHP(50);
    this.waves = 50;
  }

  public JohnPork(String name, int hp, int waves){
    super(name, hp);
    super.setmaxHP(hp);
    this.waves = waves;
  }

  public String getSpecialName(){
    return "5G Waves";
  }

  public int getSpecial(){
    return waves;
  }

  public void setSpecial(int n){
    if (n > MAX_WAVES){
      waves = MAX_WAVES;
    } else if (n<0){
      waves = 0;
    } else{
      waves = n;
    }
  }

  public int getSpecialMax(){
    return MAX_WAVES;
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
    int restoreSPAmt = 10;
    if (restoreSPAmt > getSpecialMax() - getSpecial()){
      restoreSPAmt = getSpecialMax() - getSpecial();
    }
    setHP(newHP);
    return this.getName() + " casts a healing spell on themselves for " + healAmount + " HP.";
  }

  public String specialAttack(ArrayList<Adventurer> others, int index){
    Adventurer other = others.get(index);
    if (waves < 20){
      return this.getName() + " doesn't have enough waves for a special attack!" + attack(others, index);
    }
    Random rand = new Random();
    int damage = rand.nextInt(20)+25;
    other.applyDamage(damage);
    waves -= 20;
    return this.getName() + " casts a powerful dense spell dealing " + damage + " damage to " + other.getName() + " and consumes 20 waves.";
  }
}
