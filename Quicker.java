public class Quicker{
  public static void quicksort(int[] data){

  }
  public static int partition(int[]data ,int lo, int hi){
    int vIndex = lo + (int) (Math.random()*(hi - lo + 1));
    int v = data[vIndex];
    int gt = hi;
    int i = lo + 1;
    int lt = lo + 2;
    int temp = data[lo];
    data[lo] = data[vIndex];
    data[vIndex] = temp;
    while (i <= gt){
      if (data[i] >= v){
        temp = data[i];
        data[i] = data[gt];
        data[gt] = temp;
        if (data[gt] == v){
          lt++
        }
        gt--;
      } else {
        if (data[i] == v){

        }
        i++;
      }
    }
    temp = data[lo];
    data[lo] = data[gt];
    data[gt] = temp;
    return gt;
}
