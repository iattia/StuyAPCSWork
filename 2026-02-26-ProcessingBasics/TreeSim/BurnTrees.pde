import java.util.*;
class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = -2;
  private static final int FIRE = 10;
  private static final int ASH = 0;
  private static final int SPACE = -1;
  private static final int END = 5;
  private static final int START = 5;
  public static final int PATH = 7;
  private boolean done = false;
  private int startRow, startCol;
  private boolean isStack;
  private Frontier frontier;
  private int[][][] cameFrom;
  private int endRow;
  private int endCol;
  private int MODE;
  private static final int GREEDY = 2;
  private static final int AS = 3;
  
  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    //return fireCount == 0;//placeholder for compilation purposes
    return frontier.size() == 0 || done;
  }

  public void tick() {
    ticks++;
    Location currentLoc = frontier.remove();
    int[] current = currentLoc.getPosition();
    int r = current[0];
    int c = current[1];
    int currentDist = 0;
    if (MODE == AS) {
      currentDist = currentLoc.getDistToStart();
    }
    if (map[r][c] == FIRE) {
      int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      for (int[] dir : directions) {
        int nr = r + dir[0];
        int nc = c + dir[1];
        if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[r].length) {
          if (map[nr][nc] == TREE) {
            map[nr][nc] = FIRE;
            int dend = Math.abs(endRow - nr) + Math.abs(endCol - nc);
            int dstart = 0;
            if (MODE == AS) {
              dstart = currentDist + 1;
            }
            frontier.add(new Location(new int[]{nr, nc}, dend, dstart));
            cameFrom[nr][nc] = new int[]{r, c};
          } else if (map[nr][nc] == END) {
            cameFrom[nr][nc] = new int[]{r, c};
            done = true;
            retracePath(nr, nc);
          }
        }
      }
      map[r][c] = ASH;
    }
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, int mode){
    frontier = new Frontier(mode);
    this.MODE = mode;
    map = new int[height][width];
    cameFrom = new int[height][width][2];
    for (int i = 0; i < map.length; i++){
      Arrays.fill(map[i], SPACE);
    }
    carveMaze(1, 1);
    placeSE();
    start();//set the left column on fire.
  }

  public void carveMaze(int row, int col) {
    if (!canCarve(row, col)){
      return;
    }
    map[row][col] = TREE;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    for (int i = directions.length - 1; i > 0; i--){
      int rand = (int)(Math.random() * (i + 1));
      int[] swap = directions[i];
      directions[i] = directions[rand];
      directions[rand] = swap;
    }
    for (int i = 0; i < directions.length; i++){
      carveMaze(row + directions[i][0], col+directions[i][1]);
    }
  }

  public boolean canCarve(int row, int col) {
    if (row <= 0 || row >= map.length - 1 || col <= 0 || col >= map[0].length - 1){
      return false;
    }
    if (map[row][col] != SPACE){
      return false;
    }
    int adjacentCount = 0;
    if (map[row + 1][col] == TREE){
      adjacentCount++;
    }
    if (map[row - 1][col] == TREE){
      adjacentCount++;
    }
    if (map[row][col + 1] == TREE){
      adjacentCount++;
    }
    if (map[row][col - 1] == TREE){
      adjacentCount++;
    }
    return adjacentCount < 2;
  }


  public void placeSE() {
    while (true){
      int row = (int)(Math.random() * map.length);
      int col = 1;
      if (map[row][col] == TREE){
        map[row][col] = START;
        startRow = row;
        startCol = col;
        while (true){
          row = (int)(Math.random() * map.length);
          col = map[0].length - 2;
          if (map[row][col] == TREE){
            map[row][col] = END;
            endRow = row;
            endCol = col;
            return;
          }
        }
      }
    }
  }

  public void retracePath(int endRow, int endCol) {
    while (endRow != startRow || endCol != startCol) {
      int[] root = cameFrom[endRow][endCol];
      endRow = root[0];
      endCol = root[1];
      if (endRow != startRow || endCol != startCol) {
        map[endRow][endCol] = PATH;
      }
    }
  }

  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    map[startRow][startCol] = FIRE;
    int initialDend = Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
    frontier.add(new Location(new int[]{startRow, startCol}, initialDend, 0));
  }

/*
 *Aftger the simulation is done, you can use this to determine if the fire
 *reached the right side of the map.
 */
  public boolean crossedEntireForest(){
    for (int r = 0; r < map.length; r++){
      if (map[r][map[r].length - 1] == ASH){
        return true;
      }
    }
    return false;
  }

  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }
}
