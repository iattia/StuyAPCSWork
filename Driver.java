import java.util.Arrays;

public class Driver{
  public static void main(String[] args){
    int[] arr1 = new int[]{0,1,2,3,6,7,4,3};
    Sorts.bubblesort(arr1);
    System.out.println(Arrays.toString(arr1));
  }
}
