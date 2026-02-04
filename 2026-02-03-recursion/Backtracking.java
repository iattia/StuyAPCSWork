public class Backtracking {
  public static void main(String[] args){

  }
  public static long countNoDoubleLetterWords(int length, String word, String letters) {
    if (length == 0) {
      return 1;
    }
    long count = 0;
    for (int i = 0; i < letters.length(); i++) {
      char nextChar = letters.charAt(i);
      if (word.length() > 0 && word.charAt(word.length() - 1) == nextChar) {
        continue;
      }
      count += countNoDoubleLetterWords(length - 1, word + nextChar, letters);
    }
    return count;
  }

  public static boolean groupSum(int start, int[] nums, int target) {
    if (start == nums.length) {
      return target == 0;
    }
    return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
  }

  public static boolean splitArray(int[] nums){
    return splitHelper(0,nums,0);
  }
  public static boolean splitHelper(int index, int[] nums, int diff){
    if(index == nums.length){
      return diff == 0;
    }
    return splitHelper(index + 1, nums, diff + nums[index])|| splitHelper(index + 1, nums, diff - nums[index]);
  }

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }

  }
}
