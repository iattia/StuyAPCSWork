public class Location implements Comparable<Location>{
  private int[] coordinates;
  private int distToGoal, distToStart;

  /** ********************************************************
  * COMPLETE THIS METHOD
  */
  public int compareTo(Location other){
    //compareTo will compare the distToGoal+distToStart of this vs other.
    return ((Integer)(this.distToGoal + this.distToStart)).compareTo((Integer)(other.distToGoal + other.distToStart));
  }

  public int[] getPosition(){
      return coordinates.clone();
  }

  /**Constructor of a location takes the distance to the ending location
  */
  public Location(int[] coord, int dend){
   coordinates = coord.clone();
   distToGoal = dend;
   distToStart = 0;
  }

  public Location(int[]coord, int dend, int dstart){
   coordinates = coord.clone();
   distToGoal = dend;
   distToStart = dstart;
  }

  /**Do not use this version for greedy or A*
  */
  public Location(int [] coord){
   coordinates = coord.clone();
   distToGoal = -1;
   distToStart = -1;
 }
}
