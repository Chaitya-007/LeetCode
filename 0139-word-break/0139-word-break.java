class Solution {

    public boolean fun(int ind, HashSet<String> wordSet, String s, Boolean[] dp)
    {
        if(ind == s.length())
        {
            return true;
        }

        if(dp[ind] != null) return dp[ind];

        for(int i = ind; i < s.length(); i++)
        {
            if(wordSet.contains(s.substring(ind,i+1)))
            {
                if (fun(i + 1, wordSet, s, dp))
                {
                return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<String>(wordDict);
        StringBuilder sb = new StringBuilder("");
        // boolean[] dp = new boolean[s.length()];
        Boolean[] dp = new Boolean[s.length()];

        return fun(0, wordSet, s, dp);
        
        
    }
}