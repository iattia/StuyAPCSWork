import java.util.*;

public class Driver{
  public static void main(String[] args){
    int[] a = new int[]{1,3,6,2,4,8,9,10};
    Merge.mergesort(a);
    System.out.println(Arrays.toString(a));
  }
}
