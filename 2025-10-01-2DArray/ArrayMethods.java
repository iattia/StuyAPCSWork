public class ArrayMethods{
  public static String aryToString(int[] nums){
    String newStr = "[";
    for (int i = 0; i < nums.length; i++){
      newStr += nums[i];
      newStr += ", ";
    }
    if (newStr.length() > 1){
      newStr = newStr.substring(0, newStr.length() - 2);
    }
    newStr += "]";
    return newStr;
  }
  public static String aryToString(int[][] nums){
    String newStr = "[";
    for (int i=0; i<nums.length; i++){
      newStr += aryToString(nums[i]);
      if (i<nums.length-1){
        newStr += ", ";
      }
    }
    newStr += "]";
    return newStr;
  }
  public static void main(String[] args){
    int[][] arr = new int[][]{{5,6,7},{1,2,3}};
    String result = "";
    result = aryToString(arr);
    System.out.println(result + " expected " + "[[5, 6, 7], [1, 2, 3]]");
   
  }
}
