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
      for (int j=0;j<iterator;j++){
        
      }
    }
  }
  /*Do not implement until directions are posted*/
  public static void insertionsort(int[]data){

  }
