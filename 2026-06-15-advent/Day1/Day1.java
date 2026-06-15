import java.io.*;
import java.util.*;
public class Day1{
  private static int start = 50;
  private static int count = 0;
  public static void main(String[] args){
    try{
      Scanner sc = new Scanner(new File("cases.txt"));
      while(sc.hasNextLine()){
        String current = sc.nextLine();
        String direction = current.substring(0, 1);
        int rotation = Integer.parseInt(current.substring(1));
        rotate(start, direction, rotation);
      }
    }
    catch(Exception e){
      System.out.println("file not there");
    }
    System.out.println(count);
  }
  public static void rotate(int start, String direction, int rotation){
    int dir;
    if(direction.equals("L")){
      dir = -1;
    } else{
      dir = 1;
    }
    int turned = start + dir * rotation;
    if (turned < -100 || turned > 100){
      count+= Math.abs(turned/100);
    } else if (turned <= 0){
      count++;
    }
    start = (turned + 100) % 100;
  }

}
