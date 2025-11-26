import java.util.Arrays;

public class Driver{
  public static void main(String[] args){
    int[] arr1 = genArray(-5000,5000,Integer.parseInt(args[0]));
    if (args[1].equals("insertion")){
      Sorts.insertionsort(arr1);
    }
    if (args[1].equals("selection")){
      Sorts.selectionsort(arr1);
    }
    if (args[1].equals("bubble")){
      Sorts.bubblesort(arr1);
    }
    //System.out.println(Arrays.toString(arr1));
  }
  public static int[] genArray(int min, int max, int length){
    int[] randArray = new int[length];
    for (int i=0;i<length;i++){
      randArray[i] = (int) (Math.random()*(max-min+1))+min;
    }
    return randArray;
  }
}
