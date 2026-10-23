package Problem_004_Best_Time_to_Buy_and_Sell_Stock;

import java.util.*;

// LeetCode #121: Best Time to Buy and Sell Stock

public class Solution {
    /** Returns the maximum profit from one buy followed by one sell. */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
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
