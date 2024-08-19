class Solution {
public:

    int fun(int ind, int sum, vector<int> &arr)
    {
        if(ind == 0)
        {
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || arr[0] == sum) return 1;
            return 0;
        }

        int notTake = fun(ind - 1, sum, arr);
        int take = 0;
        if(arr[ind] <= sum)
        {
            take = fun(ind - 1, sum - arr[ind], arr);
        }

        return take + notTake;
    }

    int fundp(int ind, int sum, vector<int> &arr, vector<vector<int>> &dp)
    {
        if(ind == 0)
        {
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || arr[0] == sum) return 1;
            return 0;
        }

        if(dp[ind][sum] != -1) return dp[ind][sum];

        int notTake = fundp(ind - 1, sum, arr, dp);
        int take = 0;
        if(arr[ind] <= sum)
        {
            take = fundp(ind - 1, sum - arr[ind], arr, dp);
        }

        return dp[ind][sum] = take + notTake;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        int totalSum = 0;

        for(int i = 0; i < n; i++)
        {
            totalSum += nums[i];
        }

        if((totalSum - target) < 0 || (totalSum - target)%2 != 0)
        {
            return 0;
        }

        int sum = (totalSum - target)/2;

        // return fun(n-1, sum, nums);

        // vector<vector<int>> dp(n,vector<int>(sum + 1, -1));
        // return fundp(n-1,sum,nums,dp);

        // vector<vector<int>> dp(n,vector<int>(sum + 1, 0));

        // if(nums[0] == 0)
        // {
        //     dp[0][0] = 2;
        // }
        // else
        // {
        //     dp[0][0] = 1;
        // }

        // if(nums[0] != 0 && nums[0] <= sum)
        // {
        //     dp[0][nums[0]] = 1;
        // }

        // for(int ind = 1; ind < n; ind++)
        // {
        //     for(int target = 0; target <= sum; target++)
        //     {
        //         int notTake = dp[ind - 1][target];
        //         int take = 0;
        //         if(nums[ind] <= target)
        //         {
        //             take = dp[ind - 1][target - nums[ind]];
        //         }

        //          dp[ind][target] = take + notTake;
        //     }
        // }

        // return dp[n-1][sum];

        vector<int> prev(sum + 1, 0);
        vector<int> curr(sum + 1, 0);

        if(nums[0] == 0)
        {
           prev[0] = 2;
        }
        else
        {
            prev[0] = 1;
        }

        if(nums[0] != 0 && nums[0] <= sum)
        {
            prev[nums[0]] = 1;
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 0; target <= sum; target++)
            {
                int notTake = prev[target];
                int take = 0;
                if(nums[ind] <= target)
                {
                    take = prev[target - nums[ind]];
                }

                 curr[target] = take + notTake;
            }

            prev = curr;
        }

        return prev[sum];
    }
};