import java.io.*;
import java.util.*;

public class USACO{
  public static void main(String[] args) throws FileNotFoundException{
    File file = new File("makelake.0.in");
    Scanner scanner = new Scanner(file);
    int R = scanner.nextInt();
    int C = scanner.nextInt();
    int E = scanner.nextInt();
    int N = scanner.nextInt();
    int[][] grid = new int[R][C];
    for (int r=0; r<R;r++){
      for (int c=0;c<C;c++){
        grid[r][c] = scanner.nextInt();
      }
    }
    scanner.close();
    System.out.println(Arrays.deepToString(grid));

  }
  //public int[][] getData(String filename)

  public static long bronze(String filename){
    return 0;
  }

  public static long silver(String filename){
    return 0;
  }
}
