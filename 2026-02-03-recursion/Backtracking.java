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
    if (groupSum(start + 1, nums, target - nums[start])) {
      return true;
    }
    if (groupSum(start + 1, nums, target)) {
      return true;
    }
    return false;
  }
}