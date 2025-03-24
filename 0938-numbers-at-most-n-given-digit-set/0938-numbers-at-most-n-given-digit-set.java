class Solution {

    int[][][] dp = new int[10][2][2];

    public int fun(int ind, int tight, int validnum, String s, String[] digits)
    {
        if(ind == s.length())
        {
            return (validnum == 1) ? 1 : 0;
        }

        if(dp[ind][tight][validnum] != -1)
        {
            return dp[ind][tight][validnum];
        }

        int ans = 0;

        int limit = tight == 1 ? s.charAt(ind) - '0' : 9;

        // removing all leading zeroes and those inbetween zeroes like 100, 101, 200 etc
        if(validnum == 0)
        {
            ans += fun(ind + 1, 0, 0, s, digits);
        }

        for(String str : digits)
        {
            int d = (str.charAt(0) - '0');
            int newTight = (tight == 1 && (d == limit)) ? 1 : 0;

            if(d > limit)
            {
                break;
            }

            ans += fun(ind + 1, newTight, 1, s, digits);
        }

        return dp[ind][tight][validnum] = ans;

    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String h = String.valueOf(n);

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = 0; k < 2; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fun(0,1,0,h,digits);
    }
}