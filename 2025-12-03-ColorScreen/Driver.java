public class Driver{
  public static final int WIDTH = 80;
  public static final int HEIGHT = 31;

  public static void makeBorder(){
    System.out.println(Text.CLEAR_SCREEN);
    System.out.print(Text.HIDE_CURSOR);
    Text.color(Text.background(Text.RED));
    Text.go(1, 1);
    System.out.println(" ".repeat(WIDTH));
    Text.go(HEIGHT, 1);
    Text.color(Text.background(Text.GREEN));
    System.out.print(" ".repeat(WIDTH));
    for (int i = 2; i < HEIGHT; i++) {
      Text.go(i, 1);
      Text.color(Text.background(Text.YELLOW));
      System.out.print(" ");
      Text.go(i, WIDTH);
      Text.color(Text.background(Text.BLUE));
      System.out.print(" ");
    }
    Text.go(HEIGHT+1,1);
    System.out.print(Text.RESET);
  }

  public static int[] generateNums(){
    int size = 4;
    int[] randInts = new int[size];
    for (int i=0;i<size;i++){
      randInts[i] = (int) (Math.random()*100);
    }
    return randInts;
  }
  public static void main(String[] args){
    makeBorder();
  }
}
