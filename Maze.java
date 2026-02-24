import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;
  private int startRow,startCol;



  /**Constructor

  1. load maze text file,
  2. sets animate to false by default.
  3. Set startRow and startCol based on the position of the 'S' in the maze file.
  When the file is not found then:   throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)
  -Make sure your file reading is able to handle this: maze files can have blank
  newlines at the end of the file because some text editors include a newline
  at the end of a file, but that MAY not be present.

  */
  public Maze(String filename) throws FileNotFoundException{
    String mazeString = "";
    Scanner sc = new Scanner(new File(filename));
    while (sc.hasNextLine()){
      String currentLine = sc.nextLine();
      if (!currentLine.isEmpty()){
        mazeString += currentLine + "\n";
      }
    }
    String[] arrString = mazeString.split("\n");
    int rows = arrString.length;
    int cols = arrString[0].length();
    maze = new char[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        maze[r][c] = arrString[r].charAt(c);
        if (maze[r][c] == 'S'){
          startRow = r;
          startCol = c;
        }
      }
    }
  }

  /**toString
  *@return the string that represents the maze.
  *It should look like the text file with some characters potentially replaced.
  */
  public String toString(){
    String result = "";
    for (int r = 0; r < maze.length; r++){
      for (int c = 0; c < maze[r].length; c++){
        result += maze[r][c];
      }
      result += "\n";
    }
    return result;
  }


  /**Wrapper Solve Function returns the helper function
   *@return the result of the recursive solve.
   */
  public int solve(){
    return solve(startRow, startCol);
  }

  /**Solve
  @precondition the maze is rectangular and has a border of '#' around the edges.
  @postcondition: The maze has been solved by marking a path of '@' symbols from S to E.
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'

  @return the number of @ symbols from S to E when the maze is solved, or -1 when the maze has no solution.

  */
  private int solve(int row, int col){
    if (maze[row][col] == 'E'){
      return 0;
    }
    if (maze[row][col] == '#' || maze[row][col] == '@' || maze[row][col] == '.'){
      return -1;
    }
    maze[row][col] = '@';
    int pathLength = solve(row + 1, col);
    if (pathLength > -1){
      return pathLength + 1;
    }
    pathLength = solve(row - 1, col);
    if (pathLength > -1){
      return pathLength + 1;
    }
    pathLength = solve(row, col + 1);
    if (pathLength > -1){
      return pathLength + 1;
    }
    pathLength = solve(row, col - 1);
    if (pathLength > -1){
      return pathLength + 1;
    }
    maze[row][col] = '.';
    return -1;
  }

  /*
   *Do Not Modify below this comment until discussion in class about the new methods
   */
  public Maze(int rows, int cols){
    maze = new char[rows][cols];
    for(char[]row:maze){
      for(int i = 0; i < row.length;i++){
        row[i]='#';
      }
    }
    carveMaze(1,1);
    placeSE();
  }
  public boolean canCarve(int row, int col) {
    return maze[row][col] == '#' && row != 0 && col != 0;
  }
  public void placeSE() {
  }

  public void carveMaze(int row, int col) {
    ArrayList<String> directions = new ArrayList<>(4);
    directions.add("up");
    directions.add("down");
    directions.add("left");
    directions.add("right");
    String direction = directions.get((int) Math.random(4));
    while (row > 0 && col > 0){

    }
  }


  /*
   *Do Not Modify below this comment
   */


  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

}
