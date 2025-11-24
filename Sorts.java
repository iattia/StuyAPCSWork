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

  }
}
