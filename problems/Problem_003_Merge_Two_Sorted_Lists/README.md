# Merge Two Sorted Lists

[LeetCode #21](https://leetcode.com/problems/merge-two-sorted-lists) - Easy

**Pattern:** Two pointers - sorted merge

**Recognition cue:** Both inputs are sorted, so comparing their current elements is enough to choose the next output element without sorting again.

## Core idea

Use a dummy head and a tail pointer. Repeatedly link the smaller current node to the tail, advance that input, then attach the unconsumed remainder when either list ends. The implementation relinks the existing input nodes; the unconsumed suffix is already sorted, so it can be attached directly.

## Complexity

- Time: `O(m + n)`
- Extra space: `O(1)` when relinking existing nodes

## Review note

This mutates the input lists by relinking their nodes. Be ready to explain this ownership choice; copying values into newly allocated nodes is another valid approach with different space usage.

## Revisit

- [ ] Explain why the remaining suffix is already sorted and why relinking uses constant extra space.
