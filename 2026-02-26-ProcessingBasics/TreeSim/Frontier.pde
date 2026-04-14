import java.util.ArrayDeque;

class Frontier{
  private boolean isStack = Math.random() > 0.5;
  private ArrayDeque<int[]> frontier;
  public Frontier(boolean isStack){
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
