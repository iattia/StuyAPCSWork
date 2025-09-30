public class arrayCopy{
  public static void main(String[] args){
    int[] ary = new int[]{1,2,3};
    int[] copyArray = new int[1];
    copyArray = returnCopy(ary);
    System.out.println(aryToString(copyArray));
  }
  public static int[] returnCopy(int[] ary){
    int[] arrCopy = new int[ary.length];
    for (int i=0;i<ary.length;i++){
      arrCopy[i] = ary[i];
    }
    return arrCopy;
  }
  public static String aryToString(int[] ary){
    if (ary.length == 0){
      return "[]";
    }
    String result = "[";
    for (int i=0; i<ary.length - 1; i++){
      result += ary[i]+", ";
    }
    result += ary[ary.length - 1] + "]";
    return result;
  }
}
