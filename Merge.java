
public class Merge{

  /*merge takes two sorted arrays and returns a new array that combines all
  *elements of both arrays in asorted order.
  *@left a sorted array (this is a precondition)
  *@right a sorted array (this is a precondition)
  *@return a sorted array that contains all elements of left and right
  */
  public static int [] merge(int [] left, int[] right){
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

  /*mergesortH is the actual mergesort method.
  *@data the array to be sorted
  *@return a new array that is the sorted version of data.
  */
  public static int[] mergesortH(int [] data){
    if (data.length > 1){
      int midLength = data.length/2;
      int[] left = new int[midLength];
      int[] right = new int[data.length - midLength];
      for (int i = 0; i < left.length; i++){
        left[i] = data[i];
      }
      for (int i = 0; i < right.length; i++){
        right[i] = data[i + midLength];
      }
      return merge(mergesortH(left), mergesortH(right));
    } else{
      return data;
    }
    //********************
    //COMPLETE THIS METHOD
    //********************
    /*
    if more than 1 element{
      left = copy half of data
      right = copy other half of data
      sort each half and merge them together
      return the merged array
    }else{
      return the size 1 array.
    }
    */
  }


  /* OPTIONAL */
  //Change this only if you want to do the fast version.
  public static void mergesortFast(int [] data){
    //You will need to create a second merge function and
    //a second recursive function to go with this method.
    int[] temp = dataCopy(data);
    mergesortFastH(data, temp, 0, data.length - 1);
  }

  public static void mergesortFastH(int[] data, int[] temp, int lo, int hi){

  }
  public static void mergeFast(int[] data, int[] temp, int lo, int hi){
    int mid = (lo + hi) / 2;
    for (int i = lo; i <= hi; i++){
      temp[i] = data[i];
    }
    int l = lo;
    int r = mid + 1;
    for (int i = lo; i <= hi; i++){
      if (l > mid){
        data[i] = temp[r];
        r++;
      } else if (r > hi){
        data[i] = temp[l];
        l++;
      } else if (temp[l] <= temp[r]){
        data[i] = temp[l];
        l++;
      } else{
        data[i] = temp[r];
        r++;
      }
    }
  }
  public static int[] dataCopy(int[] data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++){
      temp[i] = data[i];
    }
    return temp;
  }

  /* DO NOT MODIFY THE WRAPPER METHOD*/

  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }
}
