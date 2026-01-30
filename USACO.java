import java.io.*;
import java.util.*;

public class USACO{
  public static void main(String[] args) throws FileNotFoundException{
    int totalVolume = 0;
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
    System.out.println(Arrays.deepToString(grid));
    for (int n=0; n<N;n++){
      int R_s = scanner.nextInt()-1;
      int C_s = scanner.nextInt()-1;
      int D_s = scanner.nextInt();
      stomp(grid, R_s, C_s, D_s);
    }
    System.out.println(Arrays.deepToString(grid));
    for (int r=0; r<R;r++){
      for (int c=0;c<C;c++){
        if (E-grid[r][c]>0){
          totalVolume += E-grid[r][c];
        }
      }
    }
    totalVolume = totalVolume *72*72;
    System.out.println(totalVolume);
  }

  public static void stomp(int[][]grid, int rows, int cols, int depth){
    int currentMax = 0;
    for (int i = 0; i<3;i++){
      for (int j = 0;j<3;j++){
        if (grid[rows+i][cols+j]>currentMax){
          currentMax = grid[rows+i][cols+j];
        }
      }
    }
    int newElev = currentMax-depth;
    for (int i = 0; i<3;i++){
      for (int j = 0;j<3;j++){
        if (grid[rows+i][cols+j]>newElev){
          grid[rows+i][cols+j] = newElev;
        }
      }
    }
  }
  public static long bronze(String filename){
    return 0;
  }

  public static long silver(String filename){
    return 0;
  }
}
