import java.util.ArrayDeque;

class Frontier{
  private ArrayDeque<int[]> frontier;
  public Frontier(){
    frontier = new ArrayDeque<>();
  }
  public int size(){
    return frontier.size();
  }
  public void add(int[]location){
    frontier.addLast(location);
  }
  public int[] remove(){
    return frontier.pollLast();
  }
}
