import java.util.Arrays;
public class ArrayDemo{
  public static void main(String[]args){
    //write your tests here!
    //You can now use Arrays.toString(yourArray) instead of writing arrayToString again.
    //You also need to use Arrays.deepToString(yourArray) when it is a 2d array.
    //Compare Arrays.toString(yourArray) to YOUR arrayToString() method to make sure yours is correct
    //Compare Arrays.deeoToString(your2DArray) to YOUR arrayToString() method to make sure yours is correct
    //do not use any other Arrays.method()
    int[] arr1 = new int[]{1, 2, 3, 4, 5};
    System.out.println("Expected 0, got " + Arrays.toString(arr1).compareTo(arrToString(arr1)));
    int[][] arr2 = new int[][]{{1, 2, 3, 4, 5}, {2, 3, 4, 5}};
    System.out.println("Expected 0, got " + Arrays.deepToString(arr2).compareTo(arrToString(arr2)));
    int[][] zeroTest = new int[][]{{0, 1, 0}, {2, 3, 4}, {0, 0, 0}};
    int zeroCount = countZeros2D(zeroTest);
    System.out.println("Expected 5, got " + zeroCount);
    int[][] sumTest = new int[][]{{1, 2}, {3, 4}, {5}};
    int sum = arr2DSum(sumTest);
    System.out.println("Expected 15, got " + sum);
    int[][] negTest = {{-1, -2, -3}, {4, -5, 6}, {7, 8, -9}};
    replaceNegative(negTest);
    System.out.println("Expected [[1, 0, 0], [4, 1, 6], [7, 8, 1]], got " + Arrays.deepToString(negTest));
    int[][] original = {{10, 20}, {30, 40}};
    int[][] copied = copy(original);
    original[0][0] = 999;
    System.out.println("Expected [[10, 20], [30, 40]], got " + Arrays.deepToString(copied));
    int[][] toSwap = {{1, 2, 3}, {4, 5, 6}};
    int[][] swapped = swapRC(toSwap);
    System.out.println("Expected [[1, 4], [2, 5], [3, 6]], got " + Arrays.deepToString(swapped));
    int[][] htmlData = {{1, 2}, {3}};
    String html = htmlTable(htmlData);
    String expectedHtml = "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>";
    System.out.println("Expected HTML: " + expectedHtml);
    System.out.println("Got HTML:      " + html);
  }

  //0. Include your prior methods to help you print a 1D/2D array of ints.
  public static String arrToString(int[]ary){
    String newStr = "[";
    for (int i = 0; i < ary.length; i++){
      newStr += ary[i];
      newStr += ", ";
    }
    if (newStr.length() > 1){
      newStr = newStr.substring(0, newStr.length() - 2);
    }
    newStr += "]";
    return newStr;
  }
  //The name of different methods can be the same,
  //as long as the parameters are different! (type and/or quantity must be different)
  //Pro tip: you should be using your 1D arrToString in this method!
  public static String arrToString(int[][]ary){
    String newStr = "[";
    for (int i=0; i<ary.length; i++){
      newStr += arrToString(ary[i]);
      if (i<ary.length-1){
        newStr += ", ";
      }
    }
    newStr += "]";
    return newStr;
  }
  //1. Calculate and return how many elements equal zero in the 2D array.
  public static int countZeros2D(int[][] nums){
    int count = 0;
    for (int i=0;i<nums.length;i++){
      for (int j=0;j<nums[i].length;j++){
        if (nums[i][j] == 0){
          count++;
        }
      }
    }
    return count;
  }

  //2. Calculate the sum of a 2d array
  /*Return the sum of all of the values in the 2D array
   *Use a nested loop instead of a helper method*/
  public static int arr2DSum(int[][]nums){
    int count = 0;
    for (int i=0;i<nums.length;i++){
      for (int j=0;j<nums[i].length;j++){
        count += nums[i][j];
      }
    }
    return count;
  }

  //3. Modify a given 2D array of integer as follows:
  //Replace all the negative values:
  //-When the row number is the same as the column number replace
  //that negative with the value 1
  //-All other negatives replace with 0
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

  //4. Make a copy of the given 2d array.
  //When testing : make sure that changing the original does NOT change the copy.
  //DO NOT use any built in methods that "copy" an array.
  //You SHOULD write a helper method for this.
  //If you don't see a good way to do that, you should stop and look at prior methods.
  public static int[][] copy(int[][] nums){
    int[][] copy2d = new int[nums.length][];
    for (int i=0;i<nums.length;i++){
      copy2d[i] = new int[nums[i].length];
      for (int j=0;j<nums[i].length;j++){
        copy2d[i][j] = nums[i][j];
      }
    }
    return copy2d;
  }

  //5. Rotate an array by returning a new array with the rows and columns swapped.
  //   You may assume the array is rectangular and neither rows nor cols is 0.
  //   e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  public static int[][] swapRC(int[][]nums){
    int[][] swapped2d = new int[nums[0].length][nums.length];
    for (int i=0; i<nums.length; i++){
      for (int j=0; j<nums[0].length; j++){
        swapped2d[j][i] = nums[i][j];
      }
    }
    return swapped2d;
  }

  //6. Make an HTML table by putting a table tag around the entire 2d array,
  //   tr tags around each row, and td tags around each value.
  //   You may use a helper method
  //   Note there is no whitespace in the string, it all one line with no spaces/tabs.
  //   e.g. htmlTable(new int[][]{{1,2},{3}})  returns:
  // "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>"
  public static String htmlTable(int[][]nums){
    String html = "<table>";
    for (int i=0;i<nums.length;i++){
      html += "<tr>";
      for (int j=0;j<nums[i].length;j++){
        html = html + "<td>" + nums[i][j] + "</td>";
      }
      html += "</tr>";
    }
    html += "</table>";
    return html;
  }
}
