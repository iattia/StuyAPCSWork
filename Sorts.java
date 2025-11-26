// Time for each doubling of the list size from 10k to 20k to 40k: selection increases by 0.365s and then 1.227s, bubble increases by 0.381s and then 1.639s, and insertion increases by 0.075s and then 0.269s. As for the time curves, insertion times follow a quadratic trend: n^2, but they are fastest; bubble times also follow a quadratic trend: n^2, but are much slower; selection times follow a similar trend as bubble times: n^2, but somewhere in between insertion and bubble for actual speeds.
/*
selection: 10k: 0.223s 20k: 0.588s 40k: 1.815s 80k: 5.263s
bubble: 10k: 0.208s 20k: 0.589s 40k: 2.228s 80k: 8.773s
insertion: 10k: 0.099s 20k: 0.174s 40k: 0.443s 80k: 1.660s
*/
public class Sorts{
  public static void bubblesort(int[] arr) {
    boolean shouldContinue = true;
    int iterator = arr.length - 1;
    while (shouldContinue) {
      boolean didSwap = false;
      for (int i = 0; i < iterator; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          didSwap = true;
        }
      }
      iterator --;
      shouldContinue = didSwap;
    }
  }

  /*Do not implement until directions are posted*/
  public static void selectionsort(int[]data){
    int iterator = data.length -1;
    for (int i=0;i<iterator;i++){
      for (int j=i+1;j<iterator+1;j++){
        if (data[j] < data[i]){
          int temp = data[j];
          data[j] = data[i];
          data[i] = temp;
        }
      }
    }
  }
  /*Do not implement until directions are posted*/
  public static void insertionsort(int[]data){
    for (int i=1;i<data.length;i++){
      int current = data[i];
      int indexChecker = i-1;
      while (indexChecker >= 0 && current < data[indexChecker]){
        data[indexChecker + 1] = data[indexChecker];
        indexChecker--;
      }
      data[indexChecker + 1] = current;
    }
  }
}
