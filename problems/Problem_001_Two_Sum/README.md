# Two Sum

[LeetCode #1](https://leetcode.com/problems/two-sum) - Easy

**Pattern:** Hash map - complement lookup

**Recognition cue:** The input is unsorted, and you need to find a pair matching a target efficiently. For each item, ask whether its complement has already appeared.

## Core idea

Scan left to right, keeping a map from each previously seen value to its index. At each index, compute `target - nums[index]` and check whether that complement is already in the map. If it is, return the stored index and the current index; otherwise, store the current value and its index. Because the current value is added only after the lookup, it cannot pair with itself, while a later duplicate can still match it.

## Complexity

- Time: `O(n)` average
- Space: `O(n)`

## Review note

Remember to return indices, not values. The guaranteed-solution constraint makes a fallback unnecessary in the interview version; this implementation returns an empty array if the constraint is violated.

## Revisit

- [ ] Can explain why the lookup happens before insertion and derive the complexity without notes.
