class Solution {
public:

    int fun(int ind, int prev_ind, int n, vector<int> &nums)
    {
        if(ind == n) return 0;

        int notTake = fun(ind+1, prev_ind, n, nums);
        int take = INT_MIN;

        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
        {
            take = 1 + fun(ind+1, ind, n, nums);
        }

        return max(take,notTake);
    }

    int fundp(int ind, int prev_ind, int n, vector<int> &nums, vector<vector<int>> &dp)
    {
        if(ind == n) return 0;

        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];

        int notTake = fundp(ind+1, prev_ind, n, nums, dp);
        int take = INT_MIN;

        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
        {
            take = 1 + fundp(ind+1, ind, n, nums, dp);
        }

        return dp[ind][prev_ind + 1] = max(notTake,take);
    }

    int lengthOfLIS(vector<int>& nums) {

        int n = nums.size();
        // return fun(0,-1,n,nums); 

        // vector<vector<int>> dp(n, vector<int> (n+1,-1));
        // return fundp(0,-1,n,nums,dp);  

        // vector<vector<int>> dp(n + 1, vector<int> (n + 1, 0));
        vector<int> dp(n,1);
        // int maxi = -1;

        // for(int i = 0; i < n; i++)
        // {
        //     for(int prev = 0; prev < i; prev++)
        //     {
        //         if(nums[prev] < nums[i])
        //         {
        //             dp[i] = max(1 + dp[prev], dp[i]);
        //         }
        //     }

        //     maxi = max(maxi,dp[i]);
        // }

        // return maxi;
        int maxi = 0;

        for(int i = 0; i < n; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[prev] < nums[i])
                {
                    dp[i] = max(1 + dp[prev],dp[i]);
                }
            }
            maxi = max(maxi,dp[i]);
        }

        return maxi;

        
    }
};