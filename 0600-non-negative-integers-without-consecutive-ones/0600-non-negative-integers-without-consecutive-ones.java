class Solution {

    int[][][] dp = new int[32][2][2];

    public int fun(int ind, int tight, int prev, int n)
    {
        if(ind == 32)
        {
            return 1;
        }

        if(dp[ind][tight][prev] != -1)
        {
            return dp[ind][tight][prev];
        }

        int ans = 0;

        int limit = tight == 1 ? (n >> (31 - ind) & 1) : 1;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && (d == limit)) ? 1 : 0;
            if((d & prev) == 0)
            {
                ans += fun(ind + 1, newTight, d, n);
            }
        }

        return dp[ind][tight][prev] = ans;
    }

    public int findIntegers(int n) {

        for(int ind = 0; ind < 32; ind++)
        {
            for(int tight = 0; tight < 2; tight++)
            {
                for(int prev = 0; prev < 2; prev++)
                {
                    dp[ind][tight][prev] = -1;
                }
            }
        }

        return fun(0,1,0,n);
        
    }
}