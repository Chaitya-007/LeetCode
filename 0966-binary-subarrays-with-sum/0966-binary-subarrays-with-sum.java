class Solution {

    public int kthMost(int[] arr, int k)
    {
        // T.C -> O(2*N)
        // S.C -> O(1)


        if(k < 0) return 0;
        int n = arr.length;
        int ans = 0;
        int l = 0;
        int r = 0;
        int sum = 0;

        while(r < n) // O(N)
        {
            sum += arr[r];

            while(sum > k) // O(N) for worst case scenario
            {
               sum = sum - arr[l];
                l++;
            }

            int len = r - l + 1;
            ans += len;
            r++;
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // T.C -> O(2*2N)
        // S.C -> O(1)
        return kthMost(nums,goal) - kthMost(nums,goal-1);
    }
}