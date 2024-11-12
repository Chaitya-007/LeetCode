class Solution {

    public int fun(int ind,int[] dp)
    {
        if(ind <= 1)
        {
            return 1;
        }

        if(dp[ind] != -1) return dp[ind];

        int left = fun(ind - 1,dp);
        int right = fun(ind - 2,dp);

        return dp[ind] = left + right;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return fun(n,dp);

        dp[0] = 1;
        dp[1] = 1;

        for(int ind = 2; ind <= n; ind++)
        {
            dp[ind] = dp[ind - 1] + dp[ind - 2];
        }

        return dp[n];

    }
}