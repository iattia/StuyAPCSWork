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
    if (start >= nums.length) {
      return target == 0;
    }
    if (nums[start] == 6) {
      return groupSum6(start + 1, nums, target - 6);
    }
    return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length) {
      return target == 0;
    }
    if (groupNoAdj(start + 2, nums, target - nums[start])) {
      return true;
    }
    return groupNoAdj(start + 1, nums, target);
  }

  public static boolean splitOdd10(int[] nums) {
    return splitOdd10Helper(0, nums, 0, 0);
  }
  public static boolean splitOdd10Helper(int index, int[] nums, int sum10, int sumOdd) {
    if (index == nums.length) {
      return (sum10 % 10 == 0) && (sumOdd % 2 == 1);
    }
    if (splitOdd10Helper(index + 1, nums, sum10 + nums[index], sumOdd)) {
      return true;
    }
    return splitOdd10Helper(index + 1, nums, sum10, sumOdd + nums[index]);
  }

  public static boolean split53(int[] nums) {
    return split53Helper(0, nums, 0, 0);
  }
  public static boolean split53Helper(int index, int[] nums, int sum1, int sum2) {
    if (index == nums.length) {
      return sum1 == sum2;
    }
    int current = nums[index];
    if (current % 5 == 0) {
      return split53Helper(index + 1, nums, sum1 + current, sum2);
    }
    if (current % 3 == 0) {
      return split53Helper(index + 1, nums, sum1, sum2 + current);
    }
    return split53Helper(index + 1, nums, sum1 + current, sum2) || split53Helper(index + 1, nums, sum1, sum2 + current);
  }

  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length) {
      return target == 0;
    }
    if (nums[start] % 5 == 0) {
      if (start + 1 < nums.length && nums[start + 1] == 1) {
        return groupSum5(start + 2, nums, target - nums[start]);
      }
      return groupSum5(start + 1, nums, target - nums[start]);
    }
    return groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target);
  }

  public static boolean groupSumClump(int start, int[] nums, int target) {
    if (start >= nums.length) {
      return target == 0;
    }
    int i = start;
    int sum = 0;
    while (i < nums.length && nums[i] == nums[start]) {
      sum += nums[i];
      i++;
    }
    if (groupSumClump(i, nums, target - sum)) {
      return true;
    }
    return groupSumClump(i, nums, target);
  }
}
