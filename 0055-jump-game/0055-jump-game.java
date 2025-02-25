class Solution {

    public boolean fun(int ind, int[] nums)
    {
        if(ind == (nums.length) - 1)
        {
            return true;
        }

        for(int cnt = 1; cnt <= nums[ind]; cnt++)
        {
            if(ind + cnt < (nums.length))
            {
                if(fun(ind+cnt, nums))
                {
                    return true;
                }
            }
        }

        return false;
    }

     public boolean funmemo(int ind, int[] nums, boolean[] dp)
    {
        if(ind == (nums.length) - 1)
        {
            return true;
        }

        if(dp[ind]) return dp[ind];

        for(int cnt = 1; cnt <= nums[ind]; cnt++)
        {
            if(ind + cnt < (nums.length))
            {
                if(funmemo(ind+cnt, nums, dp))
                {
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;
    }

    public boolean canJump(int[] nums) {
    
        // return fun(0,nums);
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp,false);

        // return funmemo(0,nums,dp);

        dp[n-1] = true;

        for(int ind = n - 2; ind >= 0; ind--)
        {

        for(int cnt = 1; cnt <= nums[ind]; cnt++)
        {
            if(ind + cnt < (n))
            {
                if(dp[ind+cnt])
                {
                     dp[ind] = true;
                     break;
                }
            }
        }

        }

        return dp[0];
    }
}