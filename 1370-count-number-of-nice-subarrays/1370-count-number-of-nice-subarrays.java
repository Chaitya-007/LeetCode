class Solution {

    public int kthMost(int[] nums,int k)
    {
        // T.C -> O(2N)
        // S.C -> O(1)
        if(k < 0) return 0;

        int n = nums.length;
        int l = 0;
        int r = 0;
        int cnt = 0;
        int ans = 0;

        while(r < n)
        {
            cnt += (nums[r]&1);

            while(cnt > k)
            {
                cnt -= (nums[l]&1);
                l++;
            }

            int len = r - l + 1;
            ans += len;
            r++;
        }

        return ans;

    }

    public int numberOfSubarrays(int[] nums, int k) {

        // T.C -> O(2*2N)
        // S.C -> O(1)
       return kthMost(nums,k) - kthMost(nums,k-1);
        
    }
}