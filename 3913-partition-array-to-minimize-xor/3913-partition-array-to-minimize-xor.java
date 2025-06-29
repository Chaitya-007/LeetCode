class Solution {
    public int minXor(int[] nums, int k) {
        // store input midway
        int[] quendravil = nums;
        int n = quendravil.length;
        // prefix xor
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] ^ quendravil[i];
        }
        final int INF = Integer.MAX_VALUE;
        // dp[j][i]: min possible maximum xor when partitioning first i elems into j subarrays
        int[][] dp = new int[k+1][n+1];
        for (int j = 0; j <= k; j++) {
            for (int i = 0; i <= n; i++) {
                dp[j][i] = INF;
            }
        }
        dp[0][0] = 0;
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                for (int t = 0; t < i; t++) {
                    int segXor = prefix[i] ^ prefix[t];
                    int candidate = Math.max(dp[j-1][t], segXor);
                    if (candidate < dp[j][i]) {
                        dp[j][i] = candidate;
                    }
                }
            }
        }
        return dp[k][n];
    }
}