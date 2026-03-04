/**Modify the array as per the partition algorithm discussed in class
*@param data is the array to partition
*@param lo is the leftmost index of the array (inclusive)
*@param hi is the rightmost index of the array (inclusive)
*@return the index of the final position of the pivot element.
*preconditions:
* lo <= hi
* array.length > 0
* lo and hi are valid indices of the array
*postconditions:
* the values left of the index returned are <= p
* the values right of the index returned are >= p
* half of the values that equal p end up left of p, and half end up right of p
* the values at indices < lo are not changed
* the values at indices > hi are not changed
*/
public static int partition( int [] data, int lo, int hi){
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
  return j;
}
