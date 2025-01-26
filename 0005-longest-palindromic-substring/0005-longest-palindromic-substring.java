class Solution {

    public int check(int l, int r, String s, int[][] dp)
    {
        if(l >= r) // you are checking for each valid l and r , l has crossed r means entire string is valid
        {
            return 1;
        }

        if(dp[l][r] != -1)
        {
            return dp[l][r];
        }

        if(s.charAt(l) == s.charAt(r))
        {
            return check(l+1,r-1,s,dp);
        }

        return dp[l][r] = 0;


    }

    public String longestPalindrome(String s) {
        int n = s.length();
     int[][] dp = new int[n][n];
     for(int i = 0; i < n; i++)
     {

     Arrays.fill(dp[i],-1);
     }
     int startInd = -1;
     int maxlen = 0;

     for(int i = 0; i < n; i++)
     {
        for(int j = i; j < n; j++)
        {
            if(check(i,j,s,dp) == 1)
            {
                if((j - i + 1) > maxlen)
                {
                    maxlen = (j - i + 1);
                    startInd = i;
                }
            }
        }
     }

     return s.substring(startInd, Math.min(n,startInd + maxlen));
    }
}