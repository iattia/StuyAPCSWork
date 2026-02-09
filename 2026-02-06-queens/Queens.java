public class Queens{
  private static boolean addQueen(int r, int c, int[][] board){
    if (board[r][c] != 0){
      return false;
    }
    modifyBoard(r, c, board, true);
    return true;
  }

  private static void removeQueen(int r, int c, int[][] board){
    modifyBoard(r, c, board, false);
  }

  private static void modifyBoard(int r, int c, int[][] board, boolean isAdding){
    int modifier;
    if (isAdding){
      modifier = 1;
      board[r][c] = -1;
    } else{
      modifier = -1;
      board[r][c] = 0;
    }
    for (int i = 1; i < board.length; i++){
      if (r + i < board.length){
        if (c - i >= 0){
          board[r + i][c - i] += modifier;
        }
        if (c + i < board.length){
          board[r + i][c + i] += modifier;
        }
      }
    }
  }
}
