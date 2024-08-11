class Solution {
public:

    int fun(int i, int j, string s, string t)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s[i] == t[j])
        {
            return fun(i-1,j-1,s,t) + fun(i-1,j,s,t);
        }

        return fun(i-1,j,s,t);
    }

    int funMemo(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1)
        return dp[i][j];


        if(s[i] == t[j])
        {
            return dp[i][j] = funMemo(i-1,j-1,s,t,dp) + funMemo(i-1,j,s,t,dp);
        }

        return dp[i][j] = funMemo(i-1,j,s,t,dp);
    }

    int funMemoModified(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(j == 0) return 1;
        if(i == 0) return 0;

        if(dp[i][j] != -1)
        return dp[i][j];


        if(s[i-1] == t[j-1])
        {
            return dp[i][j] = funMemoModified(i-1,j-1,s,t,dp) + funMemoModified(i-1,j,s,t,dp);
        }

        return dp[i][j] = funMemo(i-1,j,s,t,dp);
    }


    int numDistinct(string s, string t) {
        int n = s.length();
        int m = t.length();

        // return fun(n-1,m-1,s,t);

        // vector<vector<int>> dp(n,vector<int>(m,-1));
        // return funMemo(n-1,m-1,s,t,dp); 

        vector<vector<int>> dp(n + 1,vector<int>(m + 1,-1));
        return funMemo(n,m,s,t,dp);

    }
};