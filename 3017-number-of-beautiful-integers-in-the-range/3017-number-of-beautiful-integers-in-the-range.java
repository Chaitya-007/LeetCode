class Solution {

    // dp[ind][tight][oddCount][evenCount][remainder][validNum];
    int[][][][][][] dp = new int[10][2][6][6][20][2];

    public int fun(int ind, int tight, int odd, int even, int remainder, int validnum, int k, String s)
    {
        if(ind == s.length())
        {
            return (odd == even && remainder == 0) ? 1 : 0;
        }

        // Pruning
        if(odd > 5 || even > 5)
        {
            return 0;
        }

        if(dp[ind][tight][odd][even][remainder][validnum] != -1)
        {
            return dp[ind][tight][odd][even][remainder][validnum];
        }

        int ans = 0;

        int limit = tight == 1 ? (s.charAt(ind) - '0') : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && (d == limit)) ? 1  : 0;

            if(validnum == 0 && d == 0) // handling leading zeroes
            {
                ans += fun(ind + 1, newTight, odd, even, remainder, 0, k, s);
            }
            else if(d%2 == 0)
            {
                ans += fun(ind + 1, newTight, odd, even + 1, ( (remainder * 10) + d) % k, 1, k, s);
            }
            else 
            {
                ans += fun(ind + 1, newTight, odd + 1, even, ( (remainder * 10) + d) % k, 1, k, s);

            }
        }

        return dp[ind][tight][odd][even][remainder][validnum] = ans;
    }



    public int numberOfBeautifulIntegers(int low, int high, int k) {
        
        String l = String.valueOf(low - 1);
        String h = String.valueOf(high);

        for(int ind = 0; ind < 10; ind++)
        {
            for(int tight = 0; tight < 2; tight++)
            {
                for(int odd = 0; odd < 6; odd++)
                {
                    for(int even = 0; even < 6; even++)
                    {
                        for(int remainder = 0; remainder < 20; remainder++)
                        {
                            for(int validNum = 0; validNum < 2; validNum++)
                            {
                                dp[ind][tight][odd][even][remainder][validNum] = -1;
                            }
                        }
                    }
                }
            }
        }

        int cntnum1 = fun(0,1,0,0,0,0,k,l);

        for(int ind = 0; ind < 10; ind++)
        {
            for(int tight = 0; tight < 2; tight++)
            {
                for(int odd = 0; odd < 6; odd++)
                {
                    for(int even = 0; even < 6; even++)
                    {
                        for(int remainder = 0; remainder < 20; remainder++)
                        {
                            for(int validNum = 0; validNum < 2; validNum++)
                            {
                                dp[ind][tight][odd][even][remainder][validNum] = -1;
                            }
                        }
                    }
                }
            }
        }
        int cntnum2 = fun(0,1,0,0,0,0,k,h);

        return (cntnum2 - cntnum1);

    }
}