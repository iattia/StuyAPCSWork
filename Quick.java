import java.util.*;

public class Quick{

/**This method partitions a subset of an array between two indices (between lo and hi inclusive)
    *by placing a randomly chosen pivot value between values larger than and values smaller than it.
    *All values <= pivot are at lower indices than the pivot
    *All values >= pivot are at higher indices than the pivot
    *Equal values are distributed equally on both sides.
    *@param lo is the lower index inclusive
    *@param hi is the upper index inclusive
    *@param data is the array to be partitioned
    *@postcondition The array will be be partitioned, no elements
    * before lo, or after hi will be modified.
    *@return the index of the final position of the pivot value
    */
   public static int partition(int[]data ,int lo, int hi){
     int vIndex = lo + (int) (Math.random()*(hi - lo + 1));
     int v = data[vIndex];
     int j = hi;
     int i = lo + 1;
     int temp = data[lo];
     data[lo] = data[vIndex];
     data[vIndex] = temp;
     boolean endRight = true;
     while (i <= j){
       if (data[i] > v || (data[i] == v && endRight)){
         temp = data[i];
         data[i] = data[j];
         data[j] = temp;
         if (data[j] == v){
           endRight = !endRight;
         }
         j--;
       } else {
         if (data[i] == v){
           endRight = !endRight;
         }
         i++;
       }
     }
     temp = data[lo];
     data[lo] = data[j];
     data[j] = temp;
     return j;
   }

   /**return the value that is the kth smallest value of the array.
    *k=0 is the smallest.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array will be modified by partiion.
    *@return the value of the kth smallest integer.
    */
    public static int quickselect(int []data, int k){
      int lo = 0;
      int hi = data.length - 1;
      int v = partition(data, lo, hi);
      while (v != k){
        if (v < k) {
          lo = v;
        } else if (v > k) {
          hi = v;
        }
        v = partition(data, lo, hi);
      }
      return data[v];
    }
  /*more methods to be added later*/
    /**Quicksort wrapper method, starts the recursion from 0 to len-1 inclusive.
   */
  public static void quicksort(int[]data){
    quicksort(data,0,data.length-1);
  }

  /**Quicksort
   *@param lo is the lower index inclusive
   *@param hi is the upper index inclusive
   *@param data is the array to be sorted
   *@postcondition The array between lo and hi should be sorted.
   */
  public static void quicksort(int[]data,int lo,int hi){
    if (lo >= hi){
      return;
    }
    int vIndex = partition(data, lo, hi);
    quicksort(data, lo, vIndex - 1);
    quicksort(data, vIndex + 1, hi);
  }

  public static void main(String[] args){
    int [] data = new int[] {994,995,996,4,3,2,1,0,997,998,999};
    System.out.println("Original: "+Arrays.toString(data));
    int pivot = partition( data , 3, 7);
    System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();
    data = new int[] {994,995,996,4,3,2,1,0,997,998,999};
    Arrays.sort(data);
    System.out.println(quickselect(data, 9));
  }
}
