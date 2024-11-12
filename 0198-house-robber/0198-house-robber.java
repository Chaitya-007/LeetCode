class Solution {

    public int fun(int ind, int[] nums,int[] dp)
    {
        if(ind == 0)
        {
            return nums[0];
        }

        if(ind < 0)
        {
            return 0;
        }

        if(dp[ind] != -1) return dp[ind];

        int not_pick = fun(ind - 1,nums,dp);
        int pick = nums[ind] + fun(ind-2,nums,dp);

        return dp[ind] = Math.max(not_pick,pick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        // return fun(n-1,nums,dp);

        // dp[0] = nums[0];

        // for(int ind = 1; ind < n; ind++)
        // {
        // int not_pick = dp[ind - 1];

        
        // int pick = nums[ind];
        // if(ind >=2) 
        // {
        // pick += dp[ind-2];

        // }

        //  dp[ind] = Math.max(not_pick,pick);
        // }

        // return dp[n-1];
        int prev = nums[0];
        int prev2 = 0;

        for(int ind = 1; ind < n; ind++)
        {
        int not_pick = prev;

        
        int pick = nums[ind];
        if(ind >=2) 
        {
        pick += prev2;

        }

         int curr = Math.max(not_pick,pick);
         prev2 = prev;
         prev = curr;
        }

        return prev;
    }
}