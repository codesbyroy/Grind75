package Problem_001_Two_Sum;

import java.util.*;

// LeetCode #1: Two Sum

public class Solution {
    /** Returns the indices of the two values whose sum is {@code target}. */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), index};
            }
            numToIndex.put(nums[index], index);
        }
        return new int[0];
    }

    // Test cases to validate the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case - answer at beginning
        int[] nums1 = {2, 7, 11, 15};  // 2 + 7 = 9
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        assert Arrays.equals(result1, new int[]{0, 1}) : "Test Case 1 Failed";

        // Test Case 2: Answer in middle/end of array
        int[] nums2 = {3, 2, 4};  // 2 + 4 = 6
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        assert Arrays.equals(result2, new int[]{1, 2}) : "Test Case 2 Failed";

        // Test Case 3: Duplicate values (same number used twice)
        int[] nums3 = {3, 3};  // 3 + 3 = 6
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        assert Arrays.equals(result3, new int[]{0, 1}) : "Test Case 3 Failed";

        // Test Case 4: Edge case - problem guarantees solution exists
        int[] nums4 = {1, 2, 3};
        int target4 = 7;  // No valid pair
        int[] result4 = solution.twoSum(nums4, target4);
        assert result4.length == 0 : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
