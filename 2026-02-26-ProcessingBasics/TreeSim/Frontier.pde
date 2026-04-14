import java.util.ArrayDeque;

class Frontier{
  boolean isStack = true;
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
    if (isStack){
      return frontier.pollLast();
    }
    return frontier.poll();
  }
}
