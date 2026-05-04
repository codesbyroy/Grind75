package Problem_004_Best_Time_to_Buy_and_Sell_Stock;

import java.util.*;

// LEETCODE #121 - Best Time to Buy and Sell Stock
// Difficulty: Easy
// Tags: Array, Dynamic Programming

public class Solution {
    /**
     * PROBLEM: Find maximum profit from buying and selling stock once
     *
     * KEY INSIGHTS:
     * - Can only buy once and sell once
     * - Must buy before selling (buy_day < sell_day)
     * - Want to buy at lowest price and sell at highest price after that
     * - Need to track minimum price seen so far
     *
     * APPROACHES:
     * 1. Brute Force: O(n²) - check all buy/sell pairs
     * 2. One Pass: O(n) - track min price and max profit
     *
     * ALGORITHM (One Pass):
     * 1. Track minimum price seen so far
     * 2. For each price, calculate profit if we sell today
     * 3. Update maximum profit if current profit is better
     *
     * KEY INSIGHT: At each day, we either:
     * - Found a new minimum price (potential buy day)
     * - Found a better selling opportunity
     *
     * :param prices: int[] - Array of stock prices where prices[i] is the price on day i
     * :return: int - Maximum profit that can be achieved
     */
    public int maxProfit(int[] prices) {
        // APPROACH: Single pass with tracking
        // TIME: O(n), SPACE: O(1)

        // Track the lowest price we've seen so far (best buy opportunity)
        int minPrice = Integer.MAX_VALUE;

        // Track the maximum profit we can achieve
        int maxProfit = 0;

        // Process each day's price
        for (int price : prices) {
            // Case 1: Found a new minimum price (better buy opportunity)
            if (price < minPrice) {
                minPrice = price;

            // Case 2: Current price could be a good sell opportunity
            // Calculate profit if we sell today (current price - min buy price)
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        // Return maximum profit (0 if no profitable transaction possible)
        return maxProfit;
    }

    // Test cases to validate the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Optimal buy low (day 1), sell high (day 4)
        int[] prices1 = {7, 1, 5, 3, 6, 4};  // Buy at 1, sell at 6 = profit 5
        int expected1 = 5;
        assert solution.maxProfit(prices1) == expected1 : "Test Case 1 Failed";

        // Test Case 2: Continuously decreasing - no profit possible
        int[] prices2 = {7, 6, 4, 3, 1};  // Best we can do is 0 (don't trade)
        int expected2 = 0;
        assert solution.maxProfit(prices2) == expected2 : "Test Case 2 Failed";

        // Test Case 3: Single day - can't buy and sell
        int[] prices3 = {1};
        int expected3 = 0;
        assert solution.maxProfit(prices3) == expected3 : "Test Case 3 Failed";

        // Test Case 4: Two days with profit opportunity
        int[] prices4 = {1, 5};  // Buy day 0, sell day 1
        int expected4 = 4;
        assert solution.maxProfit(prices4) == expected4 : "Test Case 4 Failed";

        // Test Case 5: Two days, no profit (decreasing)
        int[] prices5 = {5, 1};  // Can't sell before buying
        int expected5 = 0;
        assert solution.maxProfit(prices5) == expected5 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}