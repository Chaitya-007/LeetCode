class Solution {
public:

    int fun(int i, int j, string s, string t)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(s[i] == t[j])
        {
            return 1 + fun(i-1,j-1,s,t);
        }
        
        return max(fun(i-1,j,s,t),fun(i,j-1,s,t));
    }

    int fundp(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i] == t[j])
        {
            return dp[i][j] = 1 + fundp(i-1,j-1,s,t,dp);
        }
        
        return dp[i][j] = max(fundp(i-1,j,s,t,dp),fundp(i,j-1,s,t,dp));
    }

    int fundpOneShift(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(i == 0 || j == 0)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i-1] == t[j-1])
        {
            return dp[i][j] = 1 + fundpOneShift(i-1,j-1,s,t,dp);
        }
        
        return dp[i][j] = max(fundpOneShift(i-1,j,s,t,dp),fundpOneShift(i,j-1,s,t,dp));
    }

    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.length();
        int m = text2.length();
        // return fun(n-1,m-1,text1,text2);

        // vector<vector<int>> dp(n,vector<int> (m,-1));
        // return fundp(n-1,m-1,text1,text2,dp);

        // vector<vector<int>> dp(n+1,vector<int> (m+1,-1));
        // return fundpOneShift(n,m,text1,text2,dp);

        // vector<vector<int>> dp(n+1,vector<int> (m+1,0));
        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {
        //         if(text1[i-1] == text2[j-1])
        //         {
        //              dp[i][j] = 1 + dp[i-1][j-1];
        //         }
        //         else
        //         {

        //          dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }

        // return dp[n][m];

        vector<int> prev(m+1,0);
        vector<int> curr(m+1,0);

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(text1[i-1] == text2[j-1])
                {
                     curr[j] = 1 + prev[j-1];
                }
                else
                {

                 curr[j] = max(prev[j],curr[j-1]);
                }
            }

            prev = curr;
        }

        return prev[m];


    }
};