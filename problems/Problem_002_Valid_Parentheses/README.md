# Valid Parentheses

[LeetCode #20](https://leetcode.com/problems/valid-parentheses) · Easy · String, stack

## Core idea

Keep unmatched opening brackets on a stack. Each closing bracket must match the most recent opening bracket; reject it if the stack is empty or the types differ. A valid input leaves the stack empty at the end.

## Complexity

- Time: `O(n)`
- Space: `O(n)` in the worst case

## Review note

The stack captures nesting order (last opened, first closed). A closing bracket cannot be matched by searching deeper in the stack; that would incorrectly accept interleaved pairs such as `([)]`.

## Revisit

- [ ] Can derive the empty-stack and final-stack checks without notes.
