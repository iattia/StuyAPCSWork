public class Dice{
  public int die1;
  public int die2;

  public int roll(){
    die1 = (int)(Math.random() * 6) + 1;
    die2 = (int)(Math.random() * 6) + 1;
    return die1 + die2;
  }
  public boolean isDouble() {
    return die1 == die2;
  }

}
