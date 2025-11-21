public class Sorts{
  public static void bubblesort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }


  /*Do not implement until directions are posted*/
  public static void selectionsort(int[]data){}

  /*Do not implement until directions are posted*/
  public static void insertionsort(int[]data){}
}
