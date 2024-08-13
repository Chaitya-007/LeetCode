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

    int minDistance(string word1, string word2) {
     int n = word1.length();
     int m = word2.length();

    //  return fun(n-1,m-1,word1,word2);   

        vector<vector<int>> dp(n,vector<int> (m,-1));
        return fundp(n-1,m-1,word1,word2,dp);

    }
};