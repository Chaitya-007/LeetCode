class Solution {

    // Recursive Solution => TLE
    // public int DpOnStairs(int ind)
    // {
    //    if(ind == 0 || ind == 1)
    //    {
    //     return 1;
    //    }

    //    return (DpOnStairs(ind - 1) + DpOnStairs(ind - 2));
    // }

    // Memoizattion using map
    // public int memo(int ind, Map<Integer,Integer> map)
    // {
    //     if(ind == 0 || ind == 1)
    //     {
    //         return 1;
    //     }

    //     if(map.containsKey(ind))
    //     {
    //     return map.get(ind);
    //     }

    //     return  map.put(ind,memo(ind - 1,map) + memo(ind - 2,map));
    // }

    public int memo(int ind, Map<Integer, Integer> map) {
    if (ind == 0 || ind == 1) {
        return 1;
    }

    if (map.containsKey(ind)) {
        return map.get(ind);
    }

    int value = memo(ind - 1, map) + memo(ind - 2, map);
    map.put(ind, value);
    return value;
}


    // Memoization using table 
    // public int memoTable(int ind,int[] dp)
    // {
    //     if(ind == 0 || ind == 1)
    //     {
    //         return 1;
    //     }

    //     if(dp[ind] != -1)
    //     {
    //         return dp[ind];
    //     }

    //     return dp[ind] = memoTable(ind - 1,dp) + memoTable(ind - 2,dp);
    // }

    public int climbStairs(int n) {
        // Recusrive Solution
    //  int result = DpOnStairs(n);
    //  return result;   

    // Memoization using Map
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    int result = memo(n,map);
    return result;

    // Memoization using Array
    // int[] dp = new int[n+1];
    // Arrays.fill(dp,-1);
    // int result = memoTable(n,dp);
    // return result;

    // Tabulation
    // int[] dp = new int[n+1];
    // dp[0] = 1;
    // dp[1] = 1;

    // for(int i = 2; i <= n; i++)
    // {
    //     dp[i] = dp[i-1] + dp[i-2];
    // }

    // return dp[n];

    // Using Space Optimization
    // int prev = 1;
    // int prev2 = 1;

    // for(int i = 2; i <= n; i++)
    // {
    //     int curr = prev + prev2;
    //     prev2 = prev;
    //     prev = curr;
    // }

    // return prev;
    }
}