class Solution {

    public int fun(int ind,int[] nums)
    {
        if(ind == 0)  return nums[0];
        if(ind < 0) return 0;

        int pick = nums[ind] + fun(ind-2,nums);
        int not_pick = fun(ind-1,nums);

        return Math.max(pick,not_pick);
    }

    public int fundp(int ind,int[] nums, int[] dp)
    {
        if(ind == 0)  return nums[0];
        if(ind < 0) return 0;

        if(dp[ind] != -1 ) return dp[ind];

        int pick = nums[ind] + fundp(ind-2,nums,dp);
        int not_pick = fundp(ind-1,nums,dp);

        return dp[ind] = Math.max(pick,not_pick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // return fun(n-1,nums);
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return fundp(n-1,nums,dp);
    }
}