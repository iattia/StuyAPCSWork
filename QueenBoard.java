public class QueenBoard{
  private int[][]board;
  private boolean animated;
  private int delay;


  /*Initialize board with a size by size 2D array. All values should be 0*/
  public QueenBoard(int size){
    //do not change animated/delay here. ONLY change it using mutators,
    //this will default the program NOT to animate.
    animated = false;
    delay = 0;
    board = new int[size][size];
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  _ _ Q _
  Q _ _ _
  _ _ _ Q
  _ Q _ _
  *excludes the indentation, when in string form should be exactly:
  * "_ _ Q _\nQ _ _ _\n_ _ _ Q\n_ Q _ _"
  */
  public String toString(){
    String boardString = "";
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        if (board[r][c] == -1){
          boardString += "Q";
          if (c < board[r].length - 1){
            boardString += " ";
          } else{
            boardString += "\n";
          }
        } else{
          boardString += "_";
          if (c < board[r].length - 1){
            boardString += " ";
          } else{
            boardString += "\n";
          }
        }
      }
    }
    return boardString;
  }

  public String debugToString(){
    String boardString = "";
    int current;
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        current = board[r][c];
        if (current == -1){
          boardString += "Q";
          if (c < board[r].length - 1){
            boardString += " ";
          } else{
            boardString += "\n";
          }
        } else if (current > 0){
          boardString += current;
          if (c < board[r].length - 1){
            boardString += " ";
          } else{
            boardString += "\n";
          }
        } else{
          boardString += "_";
          if (c < board[r].length - 1){
            boardString += " ";
          } else{
            boardString += "\n";
          }
        }
      }
    }
    return boardString;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the instance variable board
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented.
  * Only the squares in rows that are higher index than r should be marked as threatened.
  */
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    modifyBoard(r, c, board, true);
    return true;
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    modifyBoard(r, c, board, false);
  }

  // removeQueen and addQueen helper
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

  /*reset all values of the board to 0. */
  private void clear(){

  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@precondition: the board is filled with 0's (you don't try to solve an already solved board.)
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  */
  public boolean solve(){
    return solve(0);
  }

  private boolean solve(int row){
    if (row == board.length){
      return true;
    }
    for (int col = 0; col < board[row].length; col++){
      if (addQueen(row, col)){
        if (solve(row + 1)){
          return true;
        }
        removeQueen(row, col);
      }
    }
    return false;
  }

  /**Find all possible solutions to this size board. You must clear the board before attempting to solve.
  *@return the number of solutions found, and leaves the board filled with only 0's
  */
  public int countSolutions(){
    return -1;
  }

  //DO NOT CHANGE THIS METHOD
  public void setAnimate(boolean newValue){
   animated = newValue;
  }
  //DO NOT CHANGE THIS METHOD
  public void setDelay(int newValue){
   delay = newValue;
  }

  public static void main(String[] args){
    QueenBoard a = new QueenBoard(4);
    System.out.println(a.debugToString());
    a.addQueen(0,0);
    System.out.println(a.debugToString());
    System.out.println(a.toString());
    a.removeQueen(0,0);
    System.out.println(a.solve());
  }
}
