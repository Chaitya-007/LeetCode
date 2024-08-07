class Solution {
public:

    // int fun(int ind1, int ind2, string s1,string s2)
    // {
    //     if(ind1 < 0 || ind2 < 0) return 0;

    //     if(s1[ind1] == s2[ind2]) return 1 + fun(ind1 - 1, ind2 - 1,s1,s2);

    //     return 0 + max(fun(ind1 - 1, ind2,s1,s2) , fun(ind1, ind2 - 1,s1,s2));
    // }

    int fundp(int ind1, int ind2, string s1,string s2,vector<vector<int>>& dp)
    {
        if(ind1 < 0 || ind2 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s1[ind1] == s2[ind2]) return 1 + fundp(ind1 - 1, ind2 - 1,s1,s2,dp);

        return dp[ind1][ind2] = max(fundp(ind1 - 1, ind2,s1,s2,dp) , fundp(ind1, ind2 - 1,s1,s2,dp));
    }

    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.length();
        int m = text2.length();
        string s1 = text1;
        string s2 = text2;
        // return fun(n-1,m-1,text1,text2);
        // vector<vector<int>> dp(n,vector<int>(m,-1));

        // return fundp(n-1,m-1,text1,text2,dp);

        // tabulation
        // vector<vector<int>> dp(n + 1, vector<int> (m + 1, 0));

        // for(int j = 0; j <= m; j++) dp[0][j] = 0; // if i = 0 (from string s1) then j can be anything from j = 0 to m (from string s2)

        // for(int i = 0; i <= n; i++) dp[i][0] = 0; // if j = 0 (from string s2) then i can be anything from i = 0 to n (from string s1)

        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {
        //         if(s1[i-1] == s2[j-1]) 
        //         dp[i][j] = 1 + dp[i - 1][j - 1];
        //         else
        //         dp[i][j] = max(dp[i][j-1],dp[i-1][j]);
        //     }
        // }

        // return dp[n][m];

        // Space optimization
        vector<int> prev(m+1,0);
        vector<int> curr(m+1,0);
        for(int j = 0; j <= m; j++) prev[j] = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1[i - 1] == s2[j - 1])
                curr[j] = 1 + prev[j - 1];

                else
                curr[j] = max(prev[j],curr[j-1]);
            }
            prev = curr;
        }

        return prev[m];
        
    }
};