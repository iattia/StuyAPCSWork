import java.util.*;
class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = -2;
  private static final int FIRE = 10;
  private static final int OLD_FIRE = 9;
  private static final int ASH = 0;
  private static final int SPACE = -1;
  private Frontier frontier = new Frontier();


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    //return fireCount == 0;//placeholder for compilation purposes
    return frontier.size() == 0;
  }

  public void tick(){
    ticks++;
    int cycles = frontier.size();
    for (int i = 0; i < cycles; i++){
      int[] current = frontier.remove();
      int r = current[0];
      int c = current[1];
      if (map[r][c] == FIRE) {
        if (r + 1 < map.length && map[r + 1][c] == TREE){
          map[r + 1][c] = FIRE;
          frontier.add(new int[]{r + 1, c});
        }
        if (r - 1 > -1 && map[r - 1][c] == TREE){
          map[r - 1][c] = FIRE;
          frontier.add(new int[]{r - 1, c});
        }
        if (c + 1 < map[r].length && map[r][c + 1] == TREE){
          map[r][c + 1] = FIRE;
          frontier.add(new int[]{r, c + 1});
        }
        if (c - 1 > -1 && map[r][c - 1] == TREE){
          map[r][c - 1] = FIRE;
          frontier.add(new int[]{r, c - 1});
        }
        map[r][c] = ASH;
      }
    }
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }else{
           map[r][c]=SPACE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(new int[]{i,0});
      }
    }
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
