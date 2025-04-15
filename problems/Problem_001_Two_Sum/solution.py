"""
:param nums: List[int] - List of integers
:param target: int - Target sum
:return: List[int] - Indices of the two numbers that add up to target
"""
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Dictionary to store numbers we've seen so far along with their indices.
        num_to_index = {}
        
        # Loop through the list of numbers with both index and value.
        for index, value in enumerate(nums):
            # Calculate the number needed to reach the target.
            complement = target - value
            
            # Check if this complement has already been seen.
            if complement in num_to_index:
                # If found, return the indices as the answer.
                return [num_to_index[complement], index]
            
            # Store the current number and its index in the dictionary.
            num_to_index[value] = index
        
        # Return an empty list if no valid pair is found.
        return [] 


# Test cases to validate the solution.
if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1: Basic case with two numbers adding up to target.
    nums1 = [2, 7, 11, 15]
    target1 = 9
    assert solution.twoSum(nums1, target1) == [0, 1], "Test Case 1 Failed"

    # Test Case 2: Pair exists in the middle of the list.
    nums2 = [3, 2, 4]
    target2 = 6
    assert solution.twoSum(nums2, target2) == [1, 2], "Test Case 2 Failed"

    # Test Case 3: Pair made of duplicate values.
    nums3 = [3, 3]
    target3 = 6
    assert solution.twoSum(nums3, target3) == [0, 1], "Test Case 3 Failed"

    # Test Case 4: No valid pair in the list.
    nums4 = [1, 2, 3]
    target4 = 7
    assert solution.twoSum(nums4, target4) == [], "Test Case 4 Failed"

    # All tests passed message.
    print("All test cases passed!")
