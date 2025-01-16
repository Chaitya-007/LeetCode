class Solution {

    public int fun(int i,int j, String s, String t)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }


        if(s.charAt(i) == t.charAt(j))
        {
            return 1 + fun(i-1,j-1,s,t);
        }

        return Math.max(fun(i-1,j,s,t), fun(i,j-1,s,t));
    }

    public int funMemo(int i,int j, String s, String t,int[][]dp)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
        {
            return dp[i][j] = 1 + funMemo(i-1,j-1,s,t,dp);
        }

        return dp[i][j] = Math.max(funMemo(i-1,j,s,t,dp), funMemo(i,j-1,s,t,dp));
    }

    public int funMemoShift(int i,int j, String s, String t,int[][]dp)
    {
        if(i == 0 || j == 0)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1))
        {
            return dp[i][j] = 1 + funMemoShift(i-1,j-1,s,t,dp);
        }

        return dp[i][j] = Math.max(funMemoShift(i-1,j,s,t,dp), funMemoShift(i,j-1,s,t,dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // return fun(n-1,m-1,text1,text2);

        // int[][] dp = new int[n][m];

        // for(int i = 0; i < n; i++)
        // {
        //     Arrays.fill(dp[i],-1);
        // }
        // return funMemo(n-1,m-1,text1,text2,dp);

        // int[][] dp = new int[n+1][m+1];
        // for(int i = 0; i < n+1; i++)
        // {
        //     Arrays.fill(dp[i],-1);
        // }
        // return funMemoShift(n,m,text1,text2,dp);

        // int[][] dp = new int[n+1][m+1];

        // for(int j = 0; j <= m; j++)
        // {
        //     dp[0][j] = 0;
        // }

        // for(int i = 0; i <= n; i++)
        // {
        //     dp[i][0] = 0;
        // }
        
        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {

        // if(text1.charAt(i-1) == text2.charAt(j-1))
        // {
        //      dp[i][j] = 1 + dp[i-1][j-1];
        // }
        // else
        // {
        // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        // } 

        //     }
        // }

        // return dp[n][m];

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int j = 0; j <= m; j++)
        {
            prev[j] = 0;
        }

        for(int i = 1; i <= n; i++)
        {
            curr[0] = 0;

            for(int j = 1; j <= m; j++)
            {
        if(text1.charAt(i-1) == text2.charAt(j-1))
        {
             curr[j] = 1 + prev[j-1];
        }
        else
        {
        curr[j] = Math.max(prev[j], curr[j-1]);
        } 

            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
}