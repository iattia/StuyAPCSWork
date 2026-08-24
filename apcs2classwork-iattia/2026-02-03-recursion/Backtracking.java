import java.util.*;

public class Backtracking {
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
    if (index >= nums.length) {
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
    if (start == nums.length) {
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
    if (start == nums.length) {
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

  public static void printSubsets(int[] nums){
    printSubsetsHelper(0, "", nums);
  }
  public static void printSubsetsHelper(int index, String current, int[] nums){
    if (index == nums.length){
      System.out.println(Arrays.toString(current.split(" ")));
      return;
    }
    printSubsetsHelper(index + 1, current, nums);
    printSubsetsHelper(index + 1, current + nums[index] + " ", nums);
  }

  public static void main(String[] args) {
    System.out.println("countNoDoubleLetterWords");
    System.out.println("Length 3, letters 'AB': " + countNoDoubleLetterWords(3, "", "AB") + " (Expected: 5)");
    System.out.println("Length 3, letters 'abc': " + countNoDoubleLetterWords(3, "", "abc"));

    System.out.println("groupSum");
    int[] nums1 = {2, 4, 8};
    System.out.println("{2, 4, 8}, target 10: " + groupSum(0, nums1, 10));
    System.out.println("{2, 4, 8}, target 14: " + groupSum(0, nums1, 14));
    System.out.println("{2, 4, 8}, target 9:  " + groupSum(0, nums1, 9));

    System.out.println("splitArray");
    System.out.println("{2, 2}:       " + splitArray(new int[]{2, 2}));
    System.out.println("{2, 3}:       " + splitArray(new int[]{2, 3}));
    System.out.println("{5, 2, 3}:    " + splitArray(new int[]{5, 2, 3}));

    System.out.println("groupSum6 (Must include 6s)");
    int[] nums6 = {5, 6, 2};
    System.out.println("{5, 6, 2}, target 8: " + groupSum6(0, nums6, 8));
    System.out.println("{5, 6, 2}, target 9: " + groupSum6(0, nums6, 9));
    System.out.println("{5, 6, 2}, target 7: " + groupSum6(0, nums6, 7));

    System.out.println("groupNoAdj (No adjacent numbers)");
    int[] numsAdj = {2, 5, 10, 4};
    System.out.println("{2, 5, 10, 4}, target 12: " + groupNoAdj(0, numsAdj, 12));
    System.out.println("{2, 5, 10, 4}, target 14: " + groupNoAdj(0, numsAdj, 14));
    System.out.println("{2, 5, 10, 4}, target 7:  " + groupNoAdj(0, numsAdj, 7));

    System.out.println("splitOdd10 (Group1 multiple of 10, Group2 odd)");
    System.out.println("{5, 5, 5}: " + splitOdd10(new int[]{5, 5, 5}));
    System.out.println("{5, 5, 6}: " + splitOdd10(new int[]{5, 5, 6}));

    System.out.println("split53 (Mult 5 in G1, Mult 3 in G2)");
    System.out.println("{1, 1}:       " + split53(new int[]{1, 1}));       
    System.out.println("{1, 1, 1}:    " + split53(new int[]{1, 1, 1}));    
    System.out.println("{2, 4, 2}:    " + split53(new int[]{2, 4, 2}));    
    System.out.println("{5, 3, 2}:    " + split53(new int[]{5, 3, 2}));    

    System.out.println("groupSum5 (Mult 5 included, but skip 1 if it follows 5)");
    System.out.println("{2, 5, 10, 4}, target 19: " + groupSum5(0, new int[]{2, 5, 10, 4}, 19)); 
    System.out.println("{2, 5, 10, 4}, target 17: " + groupSum5(0, new int[]{2, 5, 10, 4}, 17)); 
    System.out.println("{5, 1, 1}, target 6:      " + groupSum5(0, new int[]{5, 1, 1}, 6));     

    System.out.println("groupSumClump (Identical adjacents must be group)");
    System.out.println("{2, 4, 8}, target 10:       " + groupSumClump(0, new int[]{2, 4, 8}, 10));       
    System.out.println("{1, 2, 4, 8, 1}, target 14: " + groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14)); 
    System.out.println("{2, 2, 4, 8}, target 10:    " + groupSumClump(0, new int[]{2, 2, 4, 8}, 10));    

    System.out.println("printSubsets");
    System.out.println("Subsets of {1, 2, 3}:");
    printSubsets(new int[]{1, 2, 3});
  }
}
