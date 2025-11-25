import java.util.Arrays;

public class Driver{
  public static void main(String[] args){
    int[] arr1 = genArray(-5,5,20);
    Sorts.insertionsort(arr1);
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
