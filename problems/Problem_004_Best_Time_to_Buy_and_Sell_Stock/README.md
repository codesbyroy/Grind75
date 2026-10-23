# Best Time to Buy and Sell Stock

[LeetCode #121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) - Easy

**Pattern:** One pass - running minimum

**Recognition cue:** You need the best difference between an earlier value and the current value. Track the smallest eligible earlier value while scanning.

## Core idea

Scan prices from left to right. Track the minimum price seen before or at the current day, and evaluate the profit from selling today. Updating the minimum and best profit this way respects the requirement to buy before selling.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Review note

On a decreasing sequence, the best profit remains zero. A new minimum is a candidate buy day; only later prices can use it as a sell opportunity.

## Revisit

- [ ] Can state the scan invariant and explain why future prices never affect an earlier buy decision.
