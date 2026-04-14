import java.util.ArrayDeque;

class Frontier{
  private boolean isStack;
  private ArrayDeque<int[]> frontier;
  public Frontier(boolean isStack){
    this.isStack = isStack;
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
