import java.io.File;
import java.util.Scanner;

public class USACO{
  public static void getBronzeData(String filename){
    File bronzeFile = new File(filename);
    try{
      Scanner bronzeScan = new Scanner(bronzeFile);
    }catch (FileNotFound e){
      e.printStackTrace();
    }
    while (bronzeScan.hasNextInt()){
      System.out.println(bronzeScan.nextInt());
    }

  }
  //public int[][] getData(String filename)

  public static long bronze(String filename){
    return 0;
  }

  public static long silver(String filename){
    return 0;
  }
}
