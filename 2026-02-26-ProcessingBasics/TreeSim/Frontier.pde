public class Frontier {
  private static final int STACK = 0;
  private static final int QUEUE = 1;
  private static final int GREEDY = 2;
  private static final int AS = 3;
  private int MODE;
  private ArrayDeque<Location>deque;
  private PriorityQueue<Location>heap;

  public void add(Location place) {
    if (MODE == STACK) {
      deque.addFirst(place);          // push onto stack top
    } else if (MODE == QUEUE) {
      deque.addLast(place);           // enqueue at rear
    } else if (MODE == GREEDY || MODE == AS) {
      heap.add(place);                // insert into priority queue
    }
  }

  public Location remove() {
    if (MODE == STACK || MODE == QUEUE) {
      return deque.removeFirst();
    } else if (MODE == GREEDY || MODE == AS) {
      return heap.poll();             // extract min location
    }
    return null;
  }

  public int size() {
    if (MODE == STACK || MODE == QUEUE) {
      return deque.size();
    } else {
      return heap.size();
    }
  }

  public void clear() {
    if (MODE == STACK || MODE == QUEUE) {
      deque.clear();
    } else {
      heap.clear();
    }
  }

  public Frontier(int mode) {
    MODE = mode;
    if (mode == STACK || mode == QUEUE) {
      deque = new ArrayDeque<Location>();
    } else if (mode == GREEDY || mode == AS) {
      heap = new PriorityQueue<Location>();
    } else {
      throw new IllegalArgumentException("Please use Frontier.MODE, where MODE = HEAP/STACK/QUEUE");
    }
  }
}
