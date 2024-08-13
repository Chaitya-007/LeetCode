class Solution {
public:

    int fun(int i, int j, string s, string t)
    {
        if(j < 0) return i + 1;
        if(i < 0) return j + 1;

        if(s[i] == t[j])
        return fun(i-1,j-1,s,t);

        return 1 + min(fun(i-1,j-1,s,t),min(fun(i,j-1,s,t),fun(i-1,j,s,t)));
    }

    int fundp(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(j < 0) return i + 1;
        if(i < 0) return j + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i] == t[j])
        return dp[i][j] = fundp(i-1,j-1,s,t,dp);

        return dp[i][j] = 1 + min(fundp(i-1,j-1,s,t,dp),min(fundp(i,j-1,s,t,dp),fundp(i-1,j,s,t,dp)));
    }

    int fundpOpt(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(j == 0) return i; // very very important
        if(i == 0) return j; // very very important

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i-1] == t[j-1])
        return dp[i][j] = fundpOpt(i-1,j-1,s,t,dp);

        return dp[i][j] = 1 + min(fundpOpt(i-1,j-1,s,t,dp),min(fundpOpt(i,j-1,s,t,dp),fundpOpt(i-1,j,s,t,dp)));
    }

    int minDistance(string word1, string word2) {
     int n = word1.length();
     int m = word2.length();

    //  return fun(n-1,m-1,word1,word2);   

        // vector<vector<int>> dp(n,vector<int> (m,-1));
        // return fundp(n-1,m-1,word1,word2,dp);

        //  vector<vector<int>> dp(n+1,vector<int> (m+1,-1));
        //  return fundpOpt(n,m,word1,word2,dp);

        // vector<vector<int>> dp(n+1,vector<int> (m+1,0));
        // for(int i = 0; i <= n; i++) dp[i][0] = i;
        // for(int j = 0; j <= m; j++) dp[0][j] = j;

        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {
        //         if(word1[i-1] == word2[j-1])
        //          dp[i][j] = dp[i-1][j-1];
        //         else
        //          dp[i][j] = 1 + min(dp[i-1][j-1],min(dp[i][j-1],dp[i-1][j]));
        //     }
        // }
         
        // return dp[n][m];

        vector<int> prev(m+1,0);
        vector<int> curr(m+1,0);
        for(int j = 0; j <= m; j++) prev[j] = j;

        for(int i = 1; i <= n; i++)
        {
            curr[0] = i;
            for(int j = 1; j <= m; j++)
            {
                if(word1[i-1] == word2[j-1])
                 curr[j] = prev[j-1];
                else
                 curr[j] = 1 + min(prev[j-1],min(curr[j-1],prev[j]));
            }
            prev = curr;
        }
         
        return prev[m];
    }
};