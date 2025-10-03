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

  public static void replaceNegative(int[][] vals){
    for (int i=0; i<vals.length; i++){
      for (int j=0; j<vals[i].length; j++){
        if (vals[i][j]<0){
          if (i == j){
            vals[i][j] = 1;
          } else {
            vals[i][j] = 0;
          }
        }
      }
    }
  }

  public static int[][] copy(int[][] nums){
    int[][] newArray = new int[nums.length][]
  }

  public static void main(String[] args){
    int[][] newArray = new int[3][3];
    int[][] arr = new int[][]{{5,6,7},{1,2,3}};
    String result = "";
    result = aryToString(arr);
    System.out.println(result + " expected " + "[[5, 6, 7], [1, 2, 3]]");
    arr = new int[][]{{-1,0,3},{-3,-1,-5}};
    replaceNegative(arr);
    result = aryToString(arr);
    System.out.println(result + " expected " + "[[1, 0, 3], [0, 1, 0]]");
    newArray = copy(arr);
    System.out.println(arr + " (address should be different from " +  newArray + " ||||| copied contents: " + aryToString(newArray) + " original contents: " + aryToString(arr));

  }
}
