class Solution {
public:
    bool fun(int i, int j, string s, string t)
    {
        if(i < 0 && j < 0) return true; // both string s1 and s2 got executed

        if(i >= 0 && j < 0) return false;

        if(i < 0 && j >= 0)
        {
            for(int m = 0; m <= j; m++)
            {
                if(t[m] != '*')
                {
                    return false;
                }
            }

            return true;
        }

        if(t[j] == '*')
        {
            return fun(i,j-1,s,t) | fun(i-1,j,s,t);
        }

        if(t[j] == '?' || s[i] == t[j])
        return fun(i-1,j-1,s,t);
        
        return false;

    }

    bool funMemo(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(i < 0 && j < 0) return true; // both string s1 and s2 got executed

        if(i >= 0 && j < 0) return false;

        if(i < 0 && j >= 0)
        {
            for(int m = 0; m <= j; m++)
            {
                if(t[m] != '*')
                {
                    return false;
                }
            }

            return true;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(t[j] == '*')
        {
            return dp[i][j] = funMemo(i,j-1,s,t,dp) | funMemo(i-1,j,s,t,dp);
        }

        if(t[j] == '?' || s[i] == t[j])
        return dp[i][j] = funMemo(i-1,j-1,s,t,dp);
        


        return dp[i][j] = false;

    }

    bool funMemoOpt(int i, int j, string s, string t,vector<vector<int>> &dp)
    {
        if(i == 0 && j == 0) return true; // change 

        if(i > 0 && j == 0) return false; // change

        if(i == 0 && j > 0) // change
        {
            for(int m = 1; m <= j; m++) // change
            {
                if(t[m - 1] != '*') // change
                {
                    return false;
                }
            }

            return true;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(t[j - 1] == '*') // change
        {
            return dp[i][j] = funMemoOpt(i,j-1,s,t,dp) | funMemoOpt(i-1,j,s,t,dp);
        }

        if(t[j - 1] == '?' || s[i - 1] == t[j - 1]) // change
        return dp[i][j] = funMemoOpt(i-1,j-1,s,t,dp);
        


        return dp[i][j] = false;

    }

    

    bool isMatch(string s, string p) {
        int n = s.length();
        int m = p.length();
        // Recuusion
        // T.C -> Exponential
        // S.C -> O(N + M)
        // return fun(n-1,m-1,s,p);

        // Memoization
        // T.C -> O(n*m)
        // S.C -> O(n+m) + O(n*m)
        // vector<vector<int>> dp(n,vector<int> (m,-1));
        // return funMemo(n-1,m-1,s,p,dp);

        // One based indexing
        // vector<vector<int>> dp(n+1,vector<int> (m+1,-1));
        // return funMemoOpt(n,m,s,p,dp);


        vector<vector<bool>> dp(n+1, vector<bool> (m+1,false));

        dp[0][0] = true;

        for(int i = 1; i <= n; i++) dp[i][0] = false;

        for(int j = 1; j <= m; j++)
        {
            bool flag = true;
            for(int m = 1; m <= j; m++)
            {
                if(p[m-1] != '*')
                {
                    flag = false;
                    break;
                }
            }

            dp[0][j] = flag;
        } 

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(p[j - 1] == '*') // change
              {
                 dp[i][j] = dp[i][j-1] | dp[i-1][j];
              }

            else if(p[j - 1] == '?' || s[i - 1] == p[j - 1]) // change
            {
              dp[i][j] = dp[i-1][j-1];
            }
            else
            {
                dp[i][j] = false;

            }

            }
        }

        return dp[n][m];
    }
};