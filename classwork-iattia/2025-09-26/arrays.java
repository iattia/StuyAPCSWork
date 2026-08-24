public class arrays {
  public static void main(String[] args){
    int[] anArray = new int[11];
    System.out.println(anArray);
    for (int i=0;i<anArray.length;i++){
      anArray[i] = 100 + 10*i;
    }
    System.out.println(anArray[0]);
    System.out.println(anArray[10]);
    System.out.println(anArray[5]);
    for (int i=0;i<anArray.length;i++){
      System.out.print(anArray[i]+" ");
    }
  }
}
