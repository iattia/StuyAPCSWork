import java.util.*;

public class Driver{
  public static void main(String[] args){
    int[] arr1;
    if (args.length > 0){
      arr1 = genArray(-5000,5000,Integer.parseInt(args[0]));
    } else {
      arr1 = genArray(-5000,5000,1000000);
    }
    int[] sorted_arr1 = Arrays.copyOf(arr1, arr1.length);
    Arrays.sort(sorted_arr1);

    Heap.heapsort(arr1);
    //System.out.println(Arrays.toString(arr1));
    /*
    if (Arrays.equals(arr1, sorted_arr1)) {
      System.out.println("Array sorted correctly");
    } else {
      System.out.println("Array not sorted correctly");
    }
    */
  }
  public static int[] genArray(int min, int max, int length){
    int[] randArray = new int[length];
    for (int i=0;i<length;i++){
      randArray[i] = (int) (Math.random()*(max-min+1))+min;
    }
    return randArray;
  }
}
