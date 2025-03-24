class Solution {

    int[][][][] dp = new int[10][2][10][2];

    public int fun(int ind, int tight, int cnt, int validnum, String s)
    {
        if(ind == s.length())
        {
            return cnt;
        }

        if(dp[ind][tight][cnt][validnum] != -1)
        {
            return dp[ind][tight][cnt][validnum];
        }

        int ans = 0;

        int limit = tight == 1 ? s.charAt(ind) - '0' : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && (d == limit)) ? 1 : 0;

            if(validnum == 0 && d == 0) // adding leading zeroes
            {
                ans += fun(ind + 1, newTight, cnt, 0, s);
            }
            else if(validnum == 0 && d > 0)
            {
                if(d == 1)
                {
                    ans += fun(ind + 1, newTight, cnt + 1, 1, s);
                }
                else 
                {
                    ans += fun(ind + 1, newTight, cnt, 1, s);

                }
            }
            else if(validnum == 1)
            {
                if(d == 1)
                {
                    ans += fun(ind + 1, newTight, cnt + 1, 1, s);
                }
                else
                {
                    ans += fun(ind + 1, newTight, cnt, 1, s);
                }
            }
        }

        return dp[ind][tight][cnt][validnum] = ans;
    }

    public int countDigitOne(int n) {

        String h = String.valueOf(n);

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = 0; k < 10; k++)
                {
                    for(int m = 0; m < 2; m++)
                    {
                        dp[i][j][k][m] = -1;
                    }
                }
            }
        }

        return fun(0,1,0,0,h);
        
    }
}