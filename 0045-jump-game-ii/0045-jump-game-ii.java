class Solution {

    public int fun(int ind,int[] nums)
    {
        if(ind >= (nums.length - 1)) return 0;

        int mino = nums.length;
        for(int cnt = 1; cnt <= nums[ind]; cnt++)
        {
            int left = 1 + fun( ind+cnt, nums);
            mino = Math.min(left,mino);
        } 

        return mino;
    }

    public int funMemo(int ind,int[] nums,int[] dp)
    {
        if(ind == (nums.length - 1)) return 0;

        if(dp[ind] != -1) return dp[ind];

        int mino = nums.length;
        for(int cnt = 1; cnt <= nums[ind]; cnt++)
        {
            if(ind + cnt < nums.length)
            {
            int left = 1 + funMemo( ind+cnt, nums, dp);
            mino = Math.min(left,mino);

            }
        } 

        return dp[ind] = mino;
    }

    public int jump(int[] nums) {
        // return fun(0,nums);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return funMemo(0, nums, dp);

        // dp[n-1] = 0;

        // for(int ind = n - 2; ind >= 0; ind--)
        // {
        // int mino = nums.length;
        // for(int cnt = 1; cnt <= nums[ind]; cnt++)
        // {
        //     if(ind + cnt < n)
        //     {
        //     int left = 1 + dp[ind+cnt];
        //     mino = Math.min(left,mino);
        //     }
        // } 

        //  dp[ind] = mino;

        // }

        // return dp[0];
    }
}