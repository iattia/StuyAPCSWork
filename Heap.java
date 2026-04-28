public class Heap{
  /** URGENT NOTE:
  *   This is not a heap data structure.
  *
  *   This class only contains a static heapsort function and its
  *   required static functions.
  *   A proper heap data structure would allow for add/remove/peek,
  *   only one of which is required for the heapsort.
  */

  /**Sort the array with a heapsort.
  *This should run in nlogn time.
  */
  public static void heapsort(int[]data){
  }

  /**Convert the entire array to a valid heap
  *This should run in linear time.
  */
  private static void heapify(int[]data){
  }

  /**
  *@param: size the number of elements in the heap
  *@param: index the location to push dowh
  */
  private static void pushDown(int[]data,int size,int index){
    int leftI = index * 2 + 1;
    int rightI = index * 2 + 2;
    int largestI = index;
    if (leftI < size && data[leftI] > data[largestI]){
      largestI = leftI;
    }
    if (rightI < size && data[rightI] > data[largestI]){
      largestI = rightI;
    }
    if (largestI != index){
      int temp = data[index];
      data[index] = data[largestI];
      data[largestI] = temp;
      pushDown(data, size, largestI);
    }

  }

  /**
  *@param: size the number of elements in the heap
  */
  private static void remove(int[]data,int size){
  }

}
