class Solution {

    int[][][][] dp = new int[10][2][2][1024];

    public int fun(int ind, int tight, int isRepeat, int bitmask, String s)
    {
        if(ind == s.length())
        {
            if(bitmask != 0 && isRepeat == 1) return 1;
            return 0;
        }

        if(dp[ind][tight][isRepeat][bitmask] != -1)
        {
            return dp[ind][tight][isRepeat][bitmask];
        }

        int ans = 0;

        int limit = tight == 1 ? s.charAt(ind) - '0' : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if(bitmask == 0 && d == 0) // adding leading 0's
            {
                ans += fun(ind + 1, 0, isRepeat, bitmask, s);
            }
            else if((bitmask & (1 << d)) != 0) // if number is repeated
            {
                ans += fun(ind + 1, newTight, 1, bitmask, s);
            }
            else // if number is notRepeated => setting or adding to bitmask
            {
                ans += fun(ind + 1, newTight, isRepeat, bitmask | (1 << d), s);
            }
        }

        return dp[ind][tight][isRepeat][bitmask] = ans;
    }


    public int numDupDigitsAtMostN(int n) {

        String h = String.valueOf(n);

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = 0; k < 2; k++)
                {
                    for(int t = 0; t < 1024; t++)
                    {
                        dp[i][j][k][t] = -1;
                    }
                }
            }
        }

        return fun(0,1,0,0,h);
        
    }
}