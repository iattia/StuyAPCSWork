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
        board[r + i][c] += modifier;
        if (c - i >= 0){
          board[r + i][c - i] += modifier;
        }
        if (c + i < board.length){
          board[r + i][c + i] += modifier;
        }
      }
    }
  }

  public static void printBoard(int[][] board){
    for (int r = 0; r < board.length; r++){
      System.out.print("[");
      for (int c = 0; c < board[r].length; c++){
        System.out.print(board[r][c] + " ");
        if (c == board[r].length - 1){
          System.out.println("]");
        }
      }
    }
  }
  public static void main(String[] args) {
    int[][] board = new int[4][4];

    System.out.println("Add Queen at (0,0)");
    boolean test1 = addQueen(0, 0, board);
    System.out.println("Added (0,0): " + test1);
    printBoard(board);

    System.out.println("Add Queen at (1,2)");
    boolean test2 = addQueen(1, 2, board);
    System.out.println("Added (1,2): " + test2);
    printBoard(board);

    System.out.println("Attempt to add to threatened square (3,0)");
    boolean test3 = addQueen(3, 0, board);
    System.out.println("Added (3,0): " + test3); 
    printBoard(board);

    System.out.println("Remove Queen at (1,2)");
    removeQueen(1, 2, board);
    printBoard(board);

    System.out.println("Remove Queen at (0,0)");
    removeQueen(0, 0, board);
    printBoard(board);
  }
}
