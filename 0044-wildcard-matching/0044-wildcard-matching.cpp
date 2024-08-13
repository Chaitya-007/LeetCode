class Solution {
public:
    int fun(int i, int j, string s, string t)
    {
        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0) 
        {
            for(int m = 0; m <= j; m++)
            {
                if(t[m] != '*')
                return false;
            }
            return true;
        }

        if(t[j] == '*')
        return fun(i-1,j,s,t) | fun(i,j-1,s,t);

        if(s[i] == t[j] || t[j] == '?')
        return fun(i-1,j-1,s,t);

        return false;
    }

      int fundp(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0) 
        {
            for(int m = 0; m <= j; m++)
            {
                if(t[m] != '*')
                return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j];
        if(t[j] == '*')
        return dp[i][j] = fundp(i-1,j,s,t,dp) | fundp(i,j-1,s,t,dp);

        if(s[i] == t[j] || t[j] == '?')
        return dp[i][j] = fundp(i-1,j-1,s,t,dp);

        return dp[i][j] = false;
    }

     int fundpOpt(int i, int j, string s, string t, vector<vector<int>> &dp)
    {
        if(i == 0 && j == 0) return true; // change
        if(j == 0 && i > 0) return false; // change
        if(i == 0 && j > 0) 
        {
            for(int m = 1; m <= j; m++) // change
            {
                if(t[m-1] != '*') // change
                return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j];
        if(t[j-1] == '*')
        return dp[i][j] = fundpOpt(i-1,j,s,t,dp) | fundpOpt(i,j-1,s,t,dp);

        if(s[i-1] == t[j-1] || t[j-1] == '?')
        return dp[i][j] = fundpOpt(i-1,j-1,s,t,dp);

        return dp[i][j] = false;
    }

    bool isMatch(string s, string p) {
        int n = s.length();
        int m = p.length();

        // return fun(n-1,m-1,s,p);

        // vector<vector<int>> dp(n,vector<int>(m,-1));
        // return fundp(n-1,m-1,s,p,dp);

        // vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
        // return fundpOpt(n,m,s,p,dp);

        vector<vector<bool>> dp(n+1,vector<bool>(m+1,0));
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) dp[i][0] = false;

        for(int j = 1; j <= m; j++)
        {
            bool flag = true;
            for(int m = 1; m <= j; m++) // change
            {
                if(p[m-1] != '*') // change
                flag = false;
            }
            dp[0][j] = flag;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(p[j-1] == '*')
                 dp[i][j] = dp[i-1][j] | dp[i][j-1];
                else if(s[i-1] == p[j-1] || p[j-1] == '?')
                 dp[i][j] = dp[i-1][j-1];
                else
                 dp[i][j] = false;
            }
        }

        return dp[n][m];
    }
};