public class Witch extends Adventurer{
  private int mana, maxMana;

  public Witch(String name, int hp){
    super(name, hp);
    maxHP = 70;
    mana = 50;
    maxMana = 100;
  }

  public Witch(String name){
    this(name, 50);
  }

  public String getSpecialName(){
    return "mana";
  }
}
