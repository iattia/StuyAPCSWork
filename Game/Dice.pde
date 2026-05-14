public class Dice{
  public int die1;
  public int die2;

  public int roll(){
    die1 = (int)(Math.random() * 5) + 1;
    die2 = (int)(Math.random() * 6) + 1;
  }


}
