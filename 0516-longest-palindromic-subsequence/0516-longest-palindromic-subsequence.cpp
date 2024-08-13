class Solution {
public:

    int fun(int i, int j, string s1, string s2)
    {
        if(i < 0 || j < 0) return 0;

        if(s1[i] == s2[j]) return 1 + fun(i-1,j-1,s1,s2);

        return max(fun(i-1,j,s1,s2),fun(i,j-1,s1,s2));
    }

     int fundp(int i, int j, string s1, string s2,vector<vector<int>> &dp)
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]) return dp[i][j] = 1 + fundp(i-1,j-1,s1,s2,dp);

        return dp[i][j] = max(fundp(i-1,j,s1,s2,dp),fundp(i,j-1,s1,s2,dp));
    }

    int fundpOneShift(int i, int j, string s1, string s2,vector<vector<int>> &dp)
    {
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i-1] == s2[j-1]) return dp[i][j] = 1 + fundpOneShift(i-1,j-1,s1,s2,dp);

        return dp[i][j] = max(fundpOneShift(i-1,j,s1,s2,dp),fundpOneShift(i,j-1,s1,s2,dp));
    }

    int longestPalindromeSubseq(string s) {
        string s1 = s;
        int n = s.length();

        reverse(s.begin(),s.end());
        string s2 = s;
        int m = s2.length();

        // return fun(n-1,m-1,s1,s2);

        // vector<vector<int>> dp(n,vector<int>(m,-1));
        // return fundp(n-1,m-1,s1,s2,dp);

        // vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
        // return fundpOneShift(n,m,s1,s2,dp);

        // vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        // for(int j = 0; j <= m; j++) dp[0][j] = 0;
        // for(int i = 0; i <= n; i++) dp[i][0] = 0;

        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {
        //         if(s1[i-1] == s2[j-1])  dp[i][j] = 1 + dp[i-1][j-1];
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
                if(s1[i-1] == s2[j-1])  curr[j] = 1 + prev[j-1];
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