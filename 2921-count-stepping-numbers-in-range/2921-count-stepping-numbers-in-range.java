class Solution {

    long[][][][] dp = new long[100][2][10][2];
    int mod = (int) (1e9 + 7);
    public long fun(int ind, int tight, int prevdigit, int validnum, String s)
    {
        if(ind == s.length())
        {
            return validnum == 1 ? 1 : 0;
        }

        if(dp[ind][tight][prevdigit][validnum] != -1)
        {
            return dp[ind][tight][prevdigit][validnum];
        }

        long ans = 0;

        int limit = tight == 1 ? ( s.charAt(ind) - '0' ) : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newtight = (tight == 1 && d == limit) ? 1 : 0;
                int currdigit = d;

            if(validnum == 0 && d == 0)
            {
                ans += (fun(ind + 1, newtight, 0, validnum, s) % mod );
            }
            else if(validnum == 0 && d != 0)
            {
                ans += (fun(ind + 1, newtight, currdigit, 1, s) % mod);
            }
            else if(validnum == 1)
            {
                int diff = Math.abs(prevdigit - currdigit);
                if(diff == 1)
                {
                ans += (fun(ind + 1, newtight, currdigit, 1, s) % mod);

                }
                
            }
        }

        return dp[ind][tight][prevdigit][validnum] = ans;
        
    }

    public int countSteppingNumbers(String low, String high) {
       
        String l = String.valueOf(low);
        // String h = String.valueOf(high);

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int prev = 0; prev < 10; prev++)
                {

                for(int k = 0; k < 2; k++)
                {
                    dp[i][j][prev][k] = -1;
                }

                }
            }
        }

        long cntnum1 = fun(0,1,0,0,l);

        boolean flag = true;

        for(int i = 1; i < low.length(); i++)
        {
            int prevdigit = low.charAt(i - 1) - '0';
            int currdigit = low.charAt(i) - '0';

            int diff = Math.abs(currdigit - prevdigit);

            if(diff == 1) continue;
            else 
            {
                flag = false;
                break;
            }
        }

        if(flag) cntnum1--; 

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int prev = 0; prev < 10; prev++)
                {

                for(int k = 0; k < 2; k++)
                {
                    dp[i][j][prev][k] = -1;
                }
                
                }
            }
        }

        long cntnum2 = fun(0,1,0,0,high);

        return (int)( ( (cntnum2 - cntnum1) % mod ) + mod ) % mod;
    }
}