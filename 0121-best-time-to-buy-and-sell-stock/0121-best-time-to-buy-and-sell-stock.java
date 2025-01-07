class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int first = prices[0];

        for(int i = 1; i < prices.length; i++)
        {
            int profit = prices[i] - first;
            maxProfit = Math.max(maxProfit,profit);
            first = Math.min(first,prices[i]);
        }

        return maxProfit;
    }
}