class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int mino = prices.front();
        int maxprofit = 0;

        for(int i = 0; i < prices.size(); i++)
        {
            int profit = prices[i] - mino;

            maxprofit = max(maxprofit,profit);

            if(mino > prices[i])
            {
                mino = prices[i];
            }
           
        }

        return maxprofit;
    }
};