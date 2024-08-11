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

    int funMemo(int i, int j, string s1, string s2,vector<vector<int>> &dp)
    {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]) return dp[i][j] = funMemo(i-1,j-1,s1,s2,dp);

        return dp[i][j] = 1 + min(funMemo(i-1,j-1,s1,s2,dp),min(funMemo(i,j-1,s1,s2,dp),funMemo(i-1,j,s1,s2,dp)));
    }

    int minDistance(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();

        // return fun(n-1,m-1,word1,word2);
        vector<vector<int>> dp(n,vector<int>(m,-1));
        return funMemo(n-1,m-1,word1,word2,dp);

    }
};