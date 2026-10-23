package Problem_002_Valid_Parentheses;

import java.util.*;

// LeetCode #20: Valid Parentheses

public class Solution {
    /** Returns whether every bracket is closed in the correct order. */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('{', '}');
        mapping.put('(', ')');
        mapping.put('[', ']');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpening = stack.pop();
                if (c != mapping.get(lastOpening)) {
                    return false;
                }
            }
        }

        // Valid only if all brackets were matched (stack empty)
        // Non-empty stack means unmatched opening brackets
        return stack.isEmpty();
    }

    // Test cases to validate the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple valid case
        assert solution.isValid("()") : "Test Case 1 Failed";

        // Test Case 2: Multiple types, all valid
        assert solution.isValid("()[]{}") : "Test Case 2 Failed";

        // Test Case 3: Nested brackets (LIFO order)
        assert solution.isValid("{[()]}") : "Test Case 3 Failed";

        // Test Case 4: Wrong bracket type mismatch
        assert !solution.isValid("(]") : "Test Case 4 Failed";

        // Test Case 5: Unmatched opening brackets
        assert !solution.isValid("([") : "Test Case 5 Failed";

        // Test Case 6: Empty string is valid
        assert solution.isValid("") : "Test Case 6 Failed";

        // Test Case 7: Improper nesting (interleaved)
        assert !solution.isValid("([)]") : "Test Case 7 Failed";

        // Test Case 8: Only opening bracket
        assert !solution.isValid("[") : "Test Case 8 Failed";

        System.out.println("All test cases passed!");
    }
}
