class Solution {

    public int fun(int ind, int k, int[] nums, int[][] dp)
    {
        int n = nums.length;

        if(dp[ind][k] != -1)
        {
            return dp[ind][k];
        }

        if(ind == n)
        {
            return 0;
        }

        if(n - ind < k || k <= 0)
        {
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE;
        int xor = 0;

        for(int i = ind; i < n - k + 1; i++)
        {
            xor ^= nums[i];
            if(res > xor)
            {
                res = Math.min(res, Math.max(xor,fun(i + 1, k - 1, nums, dp)));
            }
        }

        return dp[ind][k] = res;
    }

    public int minXor(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return fun(0,k,nums,dp);
    }
}