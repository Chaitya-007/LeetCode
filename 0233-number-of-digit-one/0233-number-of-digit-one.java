class Solution {

    int[][][] dp = new int[10][2][10];

    public int fun(int ind, int tight, int cnt, String s)
    {
        if(ind == s.length())
        {
            return cnt;
        }

        if(dp[ind][tight][cnt] != -1)
        {
            return dp[ind][tight][cnt];
        }

        int ans = 0;

        int limit = tight == 1 ? s.charAt(ind) - '0' : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && (d == limit)) ? 1 : 0;

           ans += fun(ind + 1, newTight, cnt + (d == 1 ? 1 : 0), s);

        }

        return dp[ind][tight][cnt] = ans;
    }

    public int countDigitOne(int n) {

        String h = String.valueOf(n);

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = 0; k < 10; k++)
                {
                    
                        dp[i][j][k]= -1;
                    
                }
            }
        }

        return fun(0,1,0,h);
        
    }
}