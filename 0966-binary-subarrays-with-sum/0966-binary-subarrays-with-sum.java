class Solution {

    public int kthMost(int[] arr, int k)
    {
        if(k < 0) return 0;
        int n = arr.length;
        int ans = 0;
        int l = 0;
        int r = 0;
        int one = 0;

        while(r < n)
        {
            if(arr[r] == 1)
            {
                one++;
            }

            while(one > k)
            {
                if(arr[l] == 1)
                {
                    one--;
                }
                l++;
            }

            int len = r - l + 1;
            ans += len;
            r++;
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return kthMost(nums,goal) - kthMost(nums,goal-1);
    }
}