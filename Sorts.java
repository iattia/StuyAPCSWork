public class Sorts{
  public static void bubblesort(int[]data){
    boolean hasSorted = true;
    boolean didSort = false;
    while (hasSorted){
      for (int i=0;i<data.length-1-i;i++){
        if (data[i]>(data[i+1])){
          int temp = data[i];
          data[i] = data[i+1];
          data[i+1] = temp;
          didSort = true;
        }
      }
      hasSorted = didSort;
    }
  }

  /*Do not implement until directions are posted*/
  public static void selectionsort(int[]data){}

  /*Do not implement until directions are posted*/
  public static void insertionsort(int[]data){}
}
