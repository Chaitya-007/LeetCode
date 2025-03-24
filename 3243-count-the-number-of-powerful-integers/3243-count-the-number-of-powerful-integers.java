class Solution {
    long[][] dp = new long[16][2];

    public long fun(int ind, int tight, int maxallowed, String suffix, String s)
    {
        // base case : index out of bound
        if(ind == s.length())
        {
            return 1;
        }

        // already calculated
        if(dp[ind][tight] != -1)
        {
            return dp[ind][tight];
        }

        long ans = 0;

        // calculate limit for current index
        int limit = tight == 1 ? s.charAt(ind) - '0' : 9;

        limit = Math.min(limit,maxallowed);

        int suffind = s.length() - suffix.length();
        // two cases :
        // 1. Index in suffix range - special handling

        if(ind >= suffind)
        {
            // tight 0 ==> we can fill remaining places with suffix values and create matching suffix
            if(tight == 0)
            {
                return dp[ind][tight] = 1;
            }

            // if tight is true

            // if digit at num is > digit of suffix => we can create suffix definitely 
            if( s.charAt(ind) > suffix.charAt(ind - suffind) )
            {
                return dp[ind][tight] = 1;
            }
            // if digt at num is < digit of suffix => that means the suffix can't be formed
            if(s.charAt(ind) < suffix.charAt(ind - suffind) )
            {
                return dp[ind][tight] = 0;
            }

            // if digit at num == digit of suffix check for further indices
            if( s.charAt(ind) == suffix.charAt(ind - suffind) )
            {
                return dp[ind][tight] = fun(ind + 1,1, maxallowed, suffix, s); // pass tight as true
            }
        }

        // 2. Index not in suffix range - normal digit dp
        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && d == (s.charAt(ind) - '0') ) ? 1 : 0;

            ans += fun(ind + 1, newTight, maxallowed, suffix, s);
        }

        return dp[ind][tight] = ans;
    } 

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        // find answer from 1 to low - 1
        String l = String.valueOf(start - 1);
        long cntnum1 = 0;

        // if the length of low < suffix => then the suffix will never match
        if(l.length() >= s.length())
        {
            for(int i = 0; i < 16; i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    dp[i][j] = -1;
                }
            }

            cntnum1 = fun(0,1,limit,s,l);
        }

        String h = String.valueOf(finish);

        for(int i = 0; i < 16; i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    dp[i][j] = -1;
                }
            }
        long cntnum2 = fun(0,1,limit,s,h);

        return cntnum2 - cntnum1;
        
    }
}