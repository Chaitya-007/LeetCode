class Solution {

// Corrected recursive solution
private int fun(int ind, int[] nums) {
    if (ind >= nums.length - 1) return 0; // 0 additional jumps needed
    
    int minJumps = Integer.MAX_VALUE;
    for (int j = 1; j <= nums[ind]; j++) {
        if (ind + j < nums.length) {
            int jumpsNeeded = fun(ind + j, nums);
            if (jumpsNeeded != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jumpsNeeded);
            }
        }
    }
    
    return minJumps;
}

// Corrected memoized solution
private int funMemo(int ind, int[] nums, int[] memo) {
    if (ind >= nums.length - 1) return 0;
    
    if (memo[ind] != -1) return memo[ind];
    
    int minJumps = Integer.MAX_VALUE;
    for (int j = 1; j <= nums[ind]; j++) {
        if (ind + j < nums.length) {
            int jumpsNeeded = funMemo(ind + j, nums, memo);
            if (jumpsNeeded != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jumpsNeeded);
            }
        }
    }
    
    return memo[ind] = minJumps;
}


   public int jump(int[] nums) {
    int n = nums.length;
    
    // Option 1: Recursive solution
    // return fun(0, nums);
    
    // Option 2: Memoized solution
    // int[] memo = new int[n];
    // Arrays.fill(memo, -1);
    // return funMemo(0, nums, memo);
    
    // Option 3: Iterative DP solution
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[n-1] = 0; // 0 jumps needed to reach end from end
    
    for (int i = n-2; i >= 0; i--) {
        for (int j = 1; j <= nums[i] && i+j < n; j++) {
            if (dp[i+j] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }
        }
    }
    
    return dp[0];
}


}