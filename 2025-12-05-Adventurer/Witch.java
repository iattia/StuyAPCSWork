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

  public void setSepcial(int n){
    if (n > MAX_MANA){
      mana = MAX_MANA;
    } else if (n<0){
      mana = 0;
    } else{
      mana = n;
    }
  }
}
