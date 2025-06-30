class Solution {
    public int minXor(int[] nums, int k) {
        int n = nums.length;
        
        // Prefix XOR array for O(1) range XOR calculation
        int[] prefixXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ nums[i];
        }
        
        // DP table: dp[i][j] = minimum possible maximum XOR using first i elements with j partitions
        int[][] dp = new int[n + 1][k + 1];
        
        // Initialize with maximum values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Base case: 0 elements with 0 partitions = 0
        dp[0][0] = 0;
        
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                // Try all possible starting points for the j-th partition
                for (int start = j - 1; start < i; start++) {
                    if (dp[start][j - 1] != Integer.MAX_VALUE) {
                        // XOR of elements from start to i-1
                        int currentXor = prefixXor[i] ^ prefixXor[start];
                        // Update dp[i][j] with minimum of maximum XORs
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[start][j - 1], currentXor));
                    }
                }
            }
        }
        
        return dp[n][k];
    }
}