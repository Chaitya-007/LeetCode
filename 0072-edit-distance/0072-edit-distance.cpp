class Solution {
public:

    // Recusrsion
    int fun(int i, int j, string s1, string s2)
    {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(s1[i] == s2[j]) return fun(i-1,j-1,s1,s2);

        return 1 + min(fun(i-1,j-1,s1,s2),min(fun(i,j-1,s1,s2),fun(i-1,j,s1,s2)));
    }

    // Memoization
    int funMemo(int i, int j, string s1, string s2,vector<vector<int>> &dp)
    {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]) return dp[i][j] = funMemo(i-1,j-1,s1,s2,dp);

        return dp[i][j] = 1 + min(funMemo(i-1,j-1,s1,s2,dp),min(funMemo(i,j-1,s1,s2,dp),funMemo(i-1,j,s1,s2,dp)));
    }

    // One Shift Indexing
    int funMemoModified(int i, int j, string s1, string s2,vector<vector<int>> &dp)
    {
        if(i == 0) return j;
        if(j == 0) return i;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i-1] == s2[j-1]) return dp[i][j] = funMemoModified(i-1,j-1,s1,s2,dp);

        return dp[i][j] = 1 + min(funMemoModified(i-1,j-1,s1,s2,dp),min(funMemoModified(i,j-1,s1,s2,dp),funMemoModified(i-1,j,s1,s2,dp)));
    }

    int minDistance(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();

        // Recursion
        // return fun(n-1,m-1,word1,word2);

        // Memoization
        // vector<vector<int>> dp(n,vector<int>(m,-1));
        // return funMemo(n-1,m-1,word1,word2,dp);

            // Memoization using one shift indexing
            // vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
            // return funMemoModified(n,m,word1,word2,dp);

            // Tabulation
            vector<vector<int>> dp(n + 1, vector<int>(m+1,0));
            for(int j = 0; j <= m; j++) dp[0][j] = j;
            for(int i = 0; i <= n; i++) dp[i][0] = i;

            for(int i = 1; i <= n; i++)
            {
                for(int j = 1; j <= m; j++)
                {
                    if(word1[i-1] == word2[j-1])
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = 1 + min(dp[i-1][j-1],min(dp[i][j-1],dp[i-1][j]));
                    }
                }
            }

            return dp[n][m];

            // Space optimaiztion
            vector<int> prev(m+1,0);
            vector<int> curr(m+1,0);

            for(int j = 0; j <= m; j++) prev[0] = j;

            for(int i = 1; i <= n; i++)
            {
                curr[0] = i;
                for(int j = 1; j <= m; j++)
                {
                    if(word1[i-1] == word2[j-1])
                    {
                        curr[j] = 1 + prev[j-1];
                    }
                    else
                    {
                        curr[j] = 1 + min(prev[j-1],min(curr[j-1],prev[j]));
                    }
                }

                prev = curr;
            }

            return prev[m];


    }
};