# LEETCODE #20 - Valid Parentheses
# Difficulty: Easy
# Tags: String, Stack

class Solution:
    """
    PROBLEM: Determine if string of brackets is valid (properly opened/closed)
    
    KEY INSIGHTS:
    - Must be properly nested and closed in correct order
    - Every opening bracket needs matching closing bracket
    - LIFO (Last In, First Out) pattern → Stack data structure
    - Three types: (), [], {}
    
    ALGORITHM:
    1. Use stack to track opening brackets
    2. Push opening brackets onto stack
    3. For closing brackets, check if they match most recent opening
    4. Valid if stack is empty at end (all matched)
    
    EDGE CASES:
    - Empty string → valid
    - Only opening brackets → invalid
    - Only closing brackets → invalid
    - Mismatched types → invalid
    
    :param s: (str) - A string containing only the characters '(', ')', '{', '}', '[' and ']'
    :return bool
    """
    def isValid(self, s: str) -> bool:
        # APPROACH: Stack-based matching
        # TIME: O(n), SPACE: O(n) in worst case (all opening brackets)
        
        # Stack to store unmatched opening brackets
        stack = []
        
        # Map each opening bracket to its closing counterpart
        # Key insight: only need to map opening → closing
        mapping = {'{': '}', '(': ')', '[': ']'}
        
        # Process each character in the string
        for char in s:
            # Case 1: Opening bracket - store it for later matching
            if char in mapping:
                stack.append(char)
            
            # Case 2: Closing bracket - must match most recent opening
            else:
                # Invalid: closing bracket with no opening bracket
                if not stack:
                    return False
                
                # Get the most recent unmatched opening bracket
                last_opening = stack.pop()
                
                # Check if current closing bracket matches expected closing
                # mapping[last_opening] gives expected closing bracket
                if char != mapping[last_opening]:
                    return False
        
        # Valid only if all brackets were matched (stack empty)
        # Non-empty stack means unmatched opening brackets
        return len(stack) == 0

# Test cases to validate the solution
if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1: Simple valid case
    assert solution.isValid("()") == True, "Test Case 1 Failed"
    
    # Test Case 2: Multiple types, all valid
    assert solution.isValid("()[]{}") == True, "Test Case 2 Failed"
    
    # Test Case 3: Nested brackets (LIFO order)
    assert solution.isValid("{[()]}") == True, "Test Case 3 Failed"
    
    # Test Case 4: Wrong bracket type mismatch
    assert solution.isValid("(]") == False, "Test Case 4 Failed"
    
    # Test Case 5: Unmatched opening brackets
    assert solution.isValid("([") == False, "Test Case 5 Failed"
    
    # Test Case 6: Empty string is valid
    assert solution.isValid("") == True, "Test Case 6 Failed"
    
    # Test Case 7: Improper nesting (interleaved)
    assert solution.isValid("([)]") == False, "Test Case 7 Failed"
    
    # Test Case 8: Only opening bracket
    assert solution.isValid("[") == False, "Test Case 8 Failed"

    print("All test cases passed!")