class Solution:
    """
    :param s: (str) - A string containing only the characters '(', ')', '{', '}', '[' and ']'
    :return bool
    """
    def isValid(self, s: str) -> bool:
        # Initialize empty stack to store opening brackets
        stack = []
        # Dictionary mapping opening brackets to their corresponding closing brackets
        mapping = {'{': '}', '(': ')', '[': ']'}
        
        # Iterate through each character in the string
        for char in s:
            # If character is an opening bracket, append to stack
            if char in mapping:
                stack.append(char)
            else:
                # If stack is empty but we found closing bracket, return False
                if not stack:
                    return False
                # Get the last opening bracket from stack
                top = stack.pop()
                # Check if current closing bracket matches the expected one
                if char != mapping.get(top):
                    return False
        # Return True only if stack is empty (all brackets matched)
        return not stack

# Test cases to validate the solution
if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1: Valid simple parentheses
    assert solution.isValid("()") == True, "Test Case 1 Failed"
    
    # Test Case 2: Valid mixed brackets
    assert solution.isValid("()[]{}") == True, "Test Case 2 Failed"
    
    # Test Case 3: Valid nested brackets
    assert solution.isValid("{[()]}") == True, "Test Case 3 Failed"
    
    # Test Case 4: Invalid - mismatched brackets
    assert solution.isValid("(]") == False, "Test Case 4 Failed"
    
    # Test Case 5: Invalid - incomplete brackets
    assert solution.isValid("([") == False, "Test Case 5 Failed"
    
    # Test Case 6: Empty string
    assert solution.isValid("") == True, "Test Case 6 Failed"
    
    # Test Case 7: Invalid - wrong order
    assert solution.isValid("([)]") == False, "Test Case 7 Failed"
    
    # Test Case 8: Single bracket
    assert solution.isValid("[") == False, "Test Case 8 Failed"

    print("All test cases passed!")