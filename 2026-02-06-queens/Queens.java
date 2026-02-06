public class Queens{
  private static boolean addQueen(int r, int c, int[][] board){

  }

  private static void removeQueen(int r, int c, int[][] board){

  }

  private static void modifyBoard(int r, int c, int[][] board, boolean add?){
    // c-- until c=1 or r=n and c++ until c=8 or r=n
    if (add){
      while (r < board.length){
        board[r][c] = -1;
        board[r+1][c-1] += 1;
        board[r+1][c+1] += 1;
      }
    }
  }
}
