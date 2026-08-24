public class Merge{

  /**Merge two sorted arrays into one sorted array
  *@param left is a sorted array
  *@param right is a sorted array
  *@return a sorted array that contains all of the elements of both left and right combined.
  */
  public static int[] merge(int [] left, int[] right){
    int[] sorted = new int[left.length + right.length];
    int l = 0;
    int r = 0;
    int i = 0;
    while (l < left.length && r < right.length) {
      if (left[l] <= right[r]) {
        sorted[i] = left[l];
        i++;
        l++;
      } else {
        sorted[i] = right[r];
        i++;
        r++;
      }
    }
    while (l < left.length) {
      sorted[i] = left[l];
      i++;
      l++;
    }
    while (r < right.length) {
      sorted[i] = right[r];
      i++;
      r++;
    }
    return sorted;
  }
  public static void mergesort(int[] data, int[] temp, int lo, int hi){

  }
}
