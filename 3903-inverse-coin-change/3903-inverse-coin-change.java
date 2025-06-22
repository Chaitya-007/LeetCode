class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int m = numWays.length;
        long[] dp = new long[m + 1];
        dp[0] = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            long target = numWays[i - 1];
            long diff = target - dp[i];
            if (diff < 0) {
                return new ArrayList<>();
            }
            if (diff > 0) {
                ans.add(i);
                for (int j = i; j <= m; j++) {
                    dp[j] += dp[j - i];
                }
            }
            // if diff == 0, skip
        }
        // verify constructed coin set produces the same numWays
        long[] dp2 = new long[m + 1];
        dp2[0] = 1;
        for (int c : ans) {
            for (int j = c; j <= m; j++) {
                dp2[j] += dp2[j - c];
            }
        }
        for (int i = 1; i <= m; i++) {
            if (dp2[i] != numWays[i - 1]) {
                return new ArrayList<>();
            }
        }
        return ans;
        
    }
}