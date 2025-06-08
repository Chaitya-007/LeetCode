class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        // find global minimum and count its occurrences
        int mn = Integer.MAX_VALUE, cntMin = 0;
        for (int x : complexity) {
            if (x < mn) {
                mn = x;
                cntMin = 1;
            } else if (x == mn) {
                cntMin++;
            }
        }
        // 0-th computer must be the unique global minimum
        if (complexity[0] != mn || cntMin > 1) {
            return 0;
        }
        // otherwise any order of the remaining (n-1) is valid
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans = ans * i % MOD;
        }
        return (int) ans;
    }
}