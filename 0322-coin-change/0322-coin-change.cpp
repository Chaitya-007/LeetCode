class Solution {
public:
    int fun(int ind, int target, vector<int> &coins)
    {
        if(ind == 0)
        {
            if(target % coins[0] == 0)  return target/coins[0];
            else    return 1e9; 
        }

        int notTake = fun(ind - 1, target, coins);
        int take = INT_MAX;

        if(coins[ind] <= target) 
        {
            take = 1 + fun(ind, target - coins[ind], coins);
        }

        return min(take,notTake);
    }

     int fundp(int ind, int target, vector<int> &coins, vector<vector<int>> &dp)
    {
        if(ind == 0)
        {
            if(target % coins[0] == 0)  return target/coins[0];
            else    return 1e9; 
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = fundp(ind - 1, target, coins, dp);
        int take = INT_MAX;

        if(coins[ind] <= target) 
        {
            take = 1 + fundp(ind, target - coins[ind], coins, dp); // ************* fun(ind) => stay on the same index
        }

        return dp[ind][target] = min(take,notTake);
    }

    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        // int ans = fun(n-1,amount,coins);

        vector<vector<int>> dp(n, vector<int> (amount + 1, -1));
        int ans = fundp(n-1,amount,coins,dp);
        if(ans >= 1e9) return -1;
        return ans;
    }
};