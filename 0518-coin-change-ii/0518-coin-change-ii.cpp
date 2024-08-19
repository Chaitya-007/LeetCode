class Solution {
public:

    int fun(int ind, int target, vector<int> &arr)
    {
        if(ind == 0)
        {
        return (target%arr[0] == 0);
        }

        int notTake = fun(ind - 1, target, arr);
        int take = 0;
        if(arr[ind] <= target)
        {
            take = fun(ind, target - arr[ind], arr);
        }

        return take + notTake;
    }

     int fundp(int ind, int target, vector<int> &arr, vector<vector<int>> &dp)
    {
        if(ind == 0)
        {
        return (target%arr[0] == 0);
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = fundp(ind - 1, target, arr, dp);
        int take = 0;
        if(arr[ind] <= target)
        {
            take = fundp(ind, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = take + notTake;
    }

    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        // return fun(n - 1, amount, coins);

        // vector<vector<int>> dp(n, vector<int> (amount + 1, -1));
        // return fundp(n-1, amount, coins, dp);

        vector<vector<int>> dp(n, vector<int> (amount + 1, 0));
      
        for(int target = 0; target <= amount; target++)
        {
            if(target%coins[0] == 0)
            {
                dp[0][target] = (target%coins[0] == 0);
            }
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 0; target <= amount; target++)
            {
                 int notTake = dp[ind - 1][target];
                int take = 0;
                if(coins[ind] <= target)
                {
                    take = dp[ind][ target - coins[ind]];
                }

                 dp[ind][target] = take + notTake;
            }
        }

        return dp[n-1][amount];

        // vector<int> prev(amount + 1, 0);
        // vector<int> curr(amount + 1, 0);
        // prev[0] = 1;
        // for(int target = 1; target <= amount; target++)
        // {
        //     if(target%coins[0] == 0)
        //     {
        //         prev[target] = 1;
        //     }
        // }

        // for(int ind = 1; ind < n; ind++)
        // {
        //     for(int target = 0; target <= amount; target++)
        //     {
        //          int notTake = prev[target];
        //         int take = 0;
        //         if(coins[ind] <= target)
        //         {
        //             take = curr[ target - coins[ind]];
        //         }

        //          curr[target] = take + notTake;
        //     }

        //     prev = curr;
        // }

        // return prev[amount];
    }
};