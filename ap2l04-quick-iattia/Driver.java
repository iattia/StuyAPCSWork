import java.util.*;

public class Driver{
  public static void main(String[] args){
    int[] arr1;
    if (args.length > 0){
      arr1 = genArray(-5000,5000,Integer.parseInt(args[0]));
    } else {
      arr1 = genArray(-5000,5000,1000000);
    }
    Quick.quicksort(arr1);
    System.out.println(Arrays.toString(arr1));
  }
  public static int[] genArray(int min, int max, int length){
    int[] randArray = new int[length];
    for (int i=0;i<length;i++){
      randArray[i] = (int) (Math.random()*(max-min+1))+min;
    }
    return randArray;
  }
}
