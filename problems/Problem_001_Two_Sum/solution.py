from typing import List

# LEETCODE #1 - Two Sum
# Difficulty: Easy
# Tags: Array, Hash Table

class Solution:
    """
    PROBLEM: Find two numbers in array that add up to target, return their indices
    
    KEY INSIGHTS:
    - Need to find pair (a, b) where a + b = target
    - Return indices, not values
    - Exactly one solution exists (guaranteed)
    - Can't use same element twice
    
    APPROACHES:
    1. Brute Force: O(n²) - check all pairs
    2. Hash Map: O(n) - store complements as we go
    
    ALGORITHM (Hash Map):
    1. For each number, calculate its complement (target - number)
    2. Check if complement exists in our seen numbers
    3. If yes, return indices; if no, store current number
    
    :param nums: List[int] - List of integers
    :param target: int - Target sum
    :return: List[int] - Indices of the two numbers that add up to target
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # APPROACH: Hash Map (One-pass)
        # TIME: O(n), SPACE: O(n)
        
        # Hash map to store {value: index} of numbers we've seen
        # Key insight: store what we've seen, not what we're looking for
        num_to_index = {}
        
        # Single pass through array
        for index, value in enumerate(nums):
            # For current number, what do we need to reach target?
            complement = target - value
            
            # Have we seen this complement before?
            if complement in num_to_index:
                # Found the pair! Return indices (complement_index, current_index)
                # complement_index < current_index (always return in order)
                return [num_to_index[complement], index]
            
            # Haven't found pair yet, store current number for future lookups
            # This prevents using same element twice
            num_to_index[value] = index
        
        # Problem guarantees exactly one solution, so this shouldn't execute
        return [] 


# Test cases to validate the solution
if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1: Basic case - answer at beginning
    nums1 = [2, 7, 11, 15]  # 2 + 7 = 9
    target1 = 9
    assert solution.twoSum(nums1, target1) == [0, 1], "Test Case 1 Failed"

    # Test Case 2: Answer in middle/end of array
    nums2 = [3, 2, 4]  # 2 + 4 = 6
    target2 = 6
    assert solution.twoSum(nums2, target2) == [1, 2], "Test Case 2 Failed"

    # Test Case 3: Duplicate values (same number used twice)
    nums3 = [3, 3]  # 3 + 3 = 6
    target3 = 6
    assert solution.twoSum(nums3, target3) == [0, 1], "Test Case 3 Failed"

    # Test Case 4: Edge case - problem guarantees solution exists
    nums4 = [1, 2, 3]
    target4 = 7  # No valid pair
    assert solution.twoSum(nums4, target4) == [], "Test Case 4 Failed"

    print("All test cases passed!")
