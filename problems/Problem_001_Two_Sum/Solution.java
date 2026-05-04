package Problem_001_Two_Sum;

import java.util.*;

// LEETCODE #1 - Two Sum
// Difficulty: Easy
// Tags: Array, Hash Table

public class Solution {
    /**
     * PROBLEM: Find two numbers in array that add up to target, return their indices
     *
     * KEY INSIGHTS:/
     * - Need to find pair (a, b) where a + b = target
     * - Return indices, not values
     * - Exactly one solution exists (guaranteed)
     * - Can't use same element twice
     *
     * APPROACHES:
     * 1. Brute Force: O(n²) - check all pairs
     * 2. Hash Map: O(n) - store complements as we go
     *
     * ALGORITHM (Hash Map):
     * 1. For each number, calculate its complement (target - number)
     * 2. Check if complement exists in our seen numbers
     * 3. If yes, return indices; if no, store current number
     *
     * :param nums: int[] - List of integers
     * :param target: int - Target sum
     * :return: int[] - Indices of the two numbers that add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        // APPROACH: Hash Map (One-pass)
        // TIME: O(n), SPACE: O(n)

        // Hash map to store {value: index} of numbers we've seen
        // Key insight: store what we've seen, not what we're looking for
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Single pass through array
        for (int index = 0; index < nums.length; index++) {
            // For current number, what do we need to reach target?
            int complement = target - nums[index];

            // Have we seen this complement before?
            if (numToIndex.containsKey(complement)) {
                // Found the pair! Return indices (complement_index, current_index)
                // complement_index < current_index (always return in order)
                return new int[]{numToIndex.get(complement), index};
            }

            // Haven't found pair yet, store current number for future lookups
            // This prevents using same element twice
            numToIndex.put(nums[index], index);
        }

        // Problem guarantees exactly one solution, so this shouldn't execute
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