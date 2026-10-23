# Two Sum

[LeetCode #1](https://leetcode.com/problems/two-sum) - Easy

**Pattern:** Hash map - complement lookup

**Recognition cue:** The input is unsorted, and you need to find a pair matching a target efficiently. For each item, ask whether its complement has already appeared.

## Core idea

Scan once while storing each value's index. For the current value, look up `target - value` before storing the current value. Looking first prevents using the same array element twice and still handles duplicate values.

## Complexity

- Time: `O(n)` average
- Space: `O(n)`

## Review note

Remember to return indices, not values. The guaranteed-solution constraint makes a fallback unnecessary in the interview version; this implementation returns an empty array if the constraint is violated.

## Revisit

- [ ] Can explain why the lookup happens before insertion and derive the complexity without notes.
