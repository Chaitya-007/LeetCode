class Solution {
public:
    int fun(int i, int j, string s1, string s2)
    {
        if(i < 0 || j < 0) return 0;

        if(s1[i] == s2[j]) 
        return 1 + fun(i-1,j-1,s1,s2);

        return max(fun(i-1,j,s1,s2),fun(i,j-1,s1,s2));
    }

    int fundp(int i, int j, string s1, string s2, vector<vector<int>> &dp)
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s1[i] == s2[j]) 
        return dp[i][j] = 1 + fundp(i-1,j-1,s1,s2,dp);

        return dp[i][j] = max(fundp(i-1,j,s1,s2,dp),fundp(i,j-1,s1,s2,dp));
    }

    int fundpOpt(int i, int j, string s1, string s2, vector<vector<int>> &dp)
    {
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i-1] == s2[j-1]) 
        return dp[i][j] = 1 + fundpOpt(i-1,j-1,s1,s2,dp);

        return dp[i][j] = max(fundpOpt(i-1,j,s1,s2,dp),fundpOpt(i,j-1,s1,s2,dp));
    }

    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.length();
        int m = text2.length();
        // return fun(n-1,m-1,text1,text2);

        // vector<vector<int>> dp(n,vector<int>(m,-1));
        // return fundp(n-1,m-1,text1,text2,dp);

        // vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
        // return fundpOpt(n,m,text1,text2,dp);

        vector<vector<int>> dp(n+1,vector<int>(m+1,0));

        for(int i = 0; i <= n; i++)  dp[i][0] = 0;
        for(int j = 0; j <= m; j++)  dp[0][j] = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(text1[i-1] == text2[j-1]) 
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
};