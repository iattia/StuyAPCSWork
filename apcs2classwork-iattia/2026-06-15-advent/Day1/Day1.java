import java.io.*;
import java.util.Scanner;
public class Day1{
  private static int start = 50;
  private static int count = 0;
  public static void main(String[] args){
    try{
      Scanner sc = new Scanner(new File("cases.txt"));
      while(sc.hasNextLine()){
        String current = sc.nextLine();
        String stringDir = current.substring(0, 1);
        int rotation = Integer.parseInt(current.substring(1));
        rotate(start, stringDir, rotation);
        start = (start + dir * rotation + 100) % 100;
      }
    }
    catch(FileNotFoundException e){
      System.out.println("file not there");
    }
    System.out.println(count);
  }
  public static void rotate(int start, String stringDir, int rotation){
    int dir = 1;
    if(stringDir.equals("L")){
      dir = -1;
    }
    int pointing = start + dir * rotation;
    int revolutions = Math.abs(pointing/100);
    if(pointing <= 0){
      count += -pointing/100 + 1;
      if (start == 0){
        count--;
      }
    } else if(pointing > 100){
      count += pointing/100;
    }

    System.out.println(stringDir + ", " + rotation + ", " + start + ", " + count);
  }
}
