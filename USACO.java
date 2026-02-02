import java.io.*;
import java.util.*;

public class USACO{
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
  public static long bronze(String filename) throws FileNotFoundException{
    long totalVolume = 0;
    File file = new File(filename);
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
    for (int n=0; n<N;n++){
      int R_s = scanner.nextInt()-1;
      int C_s = scanner.nextInt()-1;
      int D_s = scanner.nextInt();
      stomp(grid, R_s, C_s, D_s);
    }
    for (int r=0; r<R;r++){
      for (int c=0;c<C;c++){
        if (E-grid[r][c]>0){
          totalVolume += E-grid[r][c];
        }
      }
    }
    totalVolume = totalVolume *72*72;
    return totalVolume;
  }

  public static long silver(String filename) {
    try {
        Scanner sc = new Scanner(new File(filename));
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int R1 = sc.nextInt() - 1;
        int C1 = sc.nextInt() - 1;
        int R2 = sc.nextInt() - 1;
        int C2 = sc.nextInt() - 1;
        sc.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
}
