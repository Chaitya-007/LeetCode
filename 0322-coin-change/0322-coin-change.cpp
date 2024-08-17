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

        // vector<vector<int>> dp(n, vector<int> (amount + 1, -1));
        // int ans = fundp(n-1,amount,coins,dp);

        // Tabulation
        vector<vector<int>> dp(n, vector<int> (amount + 1, 0));
        for(int T = 0; T <= amount; T++)
        {
            if(T%coins[0] == 0)
            {
            dp[0][T] = T/coins[0];
            }
            else
            {
                dp[0][T] = 1e9;
            }
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 0; target <= amount; target++)
            {
                int notTake = dp[ind - 1][target];
                int take = INT_MAX;

                if(coins[ind] <= target) 
                {
                    take = 1 + dp[ind][target - coins[ind]]; // ************* fun(ind) => stay on the same index
                }

                 dp[ind][target] = min(take,notTake);
            }
        }



        int ans = dp[n-1][amount];
        if(ans >= 1e9) return -1;
        return ans;
    }
};