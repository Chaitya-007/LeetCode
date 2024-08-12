class Solution {
public:
    bool fun(int ind,int sum,vector<int> arr)
    {
        if(sum == 0) return true;

        if(ind == 0) return arr[0] == sum;

        bool notTake = fun(ind - 1,sum,arr);
        bool take = false;

        if(arr[ind] <= sum)
        {
            take = fun(ind - 1, sum - arr[ind],arr);
        }

        return notTake | take;
    }

     bool fundp(int ind,int sum,vector<int> arr,vector<vector<int>> &dp)
    {
        if(sum == 0) return true;

        if(ind == 0) return arr[0] == sum;
        
        if(dp[ind][sum] != -1) return dp[ind][sum];

        bool notTake = fundp(ind - 1,sum,arr,dp);
        bool take = false;

        if(arr[ind] <= sum)
        {
            take = fundp(ind - 1, sum - arr[ind],arr,dp);
        }

        return dp[ind][sum] = notTake | take;
    }


    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int totalSum = 0;
        for(int i = 0; i < n; i++)
        {
            totalSum += nums[i];
        }

        if(totalSum%2 == 1)
        {
            return false;
        }

        // return fun(n-1,(totalSum/2),nums);

        // vector<vector<int>>dp (n,vector<int>(totalSum + 1, -1));
        // return fundp(n-1,(totalSum/2),nums,dp);

        // vector<vector<bool>>dp (n,vector<bool>((totalSum/2) + 1, false));
        
        // for(int ind = 0; ind < n; ind++)
        // {
        //     dp[ind][0] = true;
        // }

        // if(nums[0] <= (totalSum/2))
        // {
        //     dp[0][nums[0]] = true;
        // }

        // for(int ind = 1; ind < n; ind++)
        // {
        //     for(int target = 1; target <= (totalSum/2); target++)
        //     {
        //         bool notTake = dp[ind - 1][target];
        //         bool take = false;

        //         if(nums[ind] <= target)
        //         {
        //             take = dp[ind - 1][target - nums[ind]];
        //         }

        //       dp[ind][target] = notTake | take;
        //     }
        // }

        // return dp[n-1][totalSum/2];

        
        vector<bool> prev((totalSum/2) + 1,false);
        vector<bool> curr((totalSum/2) + 1,false);

        prev[0] = true;
        curr[0] = true;

        if(nums[0] <= (totalSum/2))
        {
            prev[nums[0]] = true;
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 1; target <= (totalSum/2); target++)
            {
                bool notTake = prev[target];
                bool take = false;

                if(nums[ind] <= target)
                {
                    take = prev[target - nums[ind]];
                }

              curr[target] = notTake | take;
            }
            prev = curr;
        }

        return prev[totalSum/2];

    }
};