package Problem_002_Valid_Parentheses;

import java.util.*;

// LeetCode #20: Valid Parentheses

public class Solution {
    /** Returns whether every bracket is closed in the correct order. */
    public boolean isValid(String s) {
        int len = s.length();
        if (len < 2) {
            return false;
        }

        Deque<Character> charStack = new ArrayDeque<>();
        Map<Character, Character> validator = new HashMap<>();
        validator.put('(', ')');
        validator.put('[', ']');
        validator.put('{', '}');

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (validator.containsKey(currentChar)) {
                charStack.push(currentChar);
            } else {
                // Edge Case: A closing bracket cannot match anything if no opening bracket is waiting on the stack.
                // This handles inputs that start with a closing bracket or contain only closing brackets.
                if (charStack.isEmpty()) {
                    return false;
                }
                char poppedComplement = validator.get(charStack.pop());
                if (poppedComplement != currentChar) {
                    return false;
                }
            }
        }

        if (!charStack.isEmpty()) {
            return false;
        }

        return true;
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

        // Test Case 6: Strings shorter than two characters are rejected
        assert !solution.isValid("") : "Test Case 6 Failed";

        // Test Case 7: Improper nesting (interleaved)
        assert !solution.isValid("([)]") : "Test Case 7 Failed";

        // Test Case 8: Only opening bracket
        assert !solution.isValid("[") : "Test Case 8 Failed";

        System.out.println("All test cases passed!");
    }
}
