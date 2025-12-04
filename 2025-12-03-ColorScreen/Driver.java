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

  private static int[] generateNums(){
    int size = 4;
    int[] randInts = new int[size];
    for (int i=0;i<size;i++){
      randInts[i] = (int) (Math.random()*100);
    }
    return randInts;
  }

  public static void printNumbers(){
    int[] nums = generateNums();
    int spacing = WIDTH/(nums.length+1);
    for (int i=0;i<nums.length;i++){
      int num = nums[i];
      int pos = (i+1)*spacing;
      Text.go(2,pos);
      if (num<25){
        Text.color(Text.RED, Text.BRIGHT);
      } else if (num > 75){
        Text.color(Text.GREEN, Text.BRIGHT);
      } else{
        Text.color(Text.WHITE);
      }
      System.out.print(num);
    }
    Text.go(HEIGHT+1,1);
    System.out.print(Text.RESET);
  }

  public static void makeSeparator(){
    int separatorStart = 3;
    Text.go(separatorStart,2);
    Text.color(Text.CYAN);
    System.out.print("-".repeat(WIDTH-2));
    Text.go(HEIGHT+1,1);
    System.out.print(Text.RESET);
  }

public static void makeExtra() {
  int centerX = WIDTH / 2;
  int topY = 6;
  int treeHeight = 15;
  for (int i = 0; i < treeHeight; i++) {
    int width = (i * 2) + 1;
    Text.go(topY + i, centerX - i);   
    Text.color(Text.GREEN);
    System.out.print("*".repeat(width));
  }
  int trunkTop = topY + treeHeight;
  for (int i = 0; i < 6; i++) {
    Text.go(trunkTop + i, centerX - 1); 
    Text.color(Text.YELLOW); 
    System.out.print("|||");
  }
  Text.go(HEIGHT+1,1);
  System.out.print(Text.RESET);
}
  public static void main(String[] args){
    makeBorder();
    printNumbers();
    makeSeparator();
    makeExtra();
  }
}
