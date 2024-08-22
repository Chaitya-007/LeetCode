class Solution {
public:
    int fun(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(j < 0) return  i + 1;
        if(i < 0) return j + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i] == t[j])
        {
            return dp[i][j] = fun(i-1,j-1,s,t,dp);
        }

        return dp[i][j] =  1 + min(fun(i-1,j-1,s,t,dp), min(fun(i-1,j,s,t,dp), fun(i,j-1,s,t,dp) ));
    }

     int funOpt(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(j == 0) return  i;
        if(i == 0) return j;

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i-1] == t[j-1])
        {
            return funOpt(i-1,j-1,s,t,dp);
        }

        return  1 + min(funOpt(i-1,j-1,s,t,dp), min(funOpt(i-1,j,s,t,dp), funOpt(i,j-1,s,t,dp) ));
    }

    int minDistance(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();

        vector<vector<int>> dp(n, vector<int> (m, -1));
        return fun(n-1,m-1,word1,word2,dp);

        //  vector<vector<int>> dp(n + 1, vector<int> (m + 1, -1));
        // return funOpt(n,m,word1,word2,dp);

        // vector<vector<int>> dp(n + 1, vector<int> (m + 1, 0));
        // for(int i = 0; i <= n; i++)
        // {
        //     dp[i][0] = i; 
        // }

        // for(int j = 1; j <= m; j++)
        // {
        //     dp[0][j] = j;
        // }

        // for(int i = 1; i <= n; i++)
        // {
        //     for(int j = 1; j <= m; j++)
        //     {
        //             if(s[i-1] == t[j-1])
        //             {
        //                 return funOpt(i-1,j-1,s,t,dp);
        //             }

        //             return  1 + min(funOpt(i-1,j-1,s,t,dp), min(funOpt(i-1,j,s,t,dp), funOpt(i,j-1,s,t,dp) ));
        //     }
        // }
    }
};