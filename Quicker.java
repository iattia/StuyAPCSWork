public class Quicker{
  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int[] bounds = partition(data, lo, hi);
    quicksort(data, lo, bounds[0] - 1);
    quicksort(data, bounds[1] + 1, hi);
  }
  public static int[] partition(int[] data, int lo, int hi){
    int vIndex = lo + (int)(Math.random() * (hi - lo + 1));
    int v = data[vIndex];
    int temp = data[lo];
    data[lo] = data[vIndex];
    data[vIndex] = temp;
    int lt = lo;
    int i  = lo + 1;
    int gt = hi;
    while (i <= gt){
      if (data[i] < v){
        temp = data[i];
        data[i] = data[lt];
        data[lt] = temp;
        lt++;
        i++;
      } else if (data[i] > v){
        temp = data[i];
        data[i] = data[gt];
        data[gt] = temp;
        gt--;
      } else {
        i++;
      }
    }
    return new int[]{lt, gt};
  }
}
