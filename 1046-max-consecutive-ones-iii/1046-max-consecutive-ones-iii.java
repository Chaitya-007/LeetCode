class Solution {
    public int longestOnes(int[] nums, int k) {

        // T.C -> O(N)
        // S.C -> O(1)

        int n = nums.length;

        int l = 0;
        int r = 0;
        int maxlen = 0;
        int cnt = 0;

        while(r < n)
        {
            if(nums[r] == 0)
            {
                cnt++;
            }

            if(cnt > k)
            {
                if(nums[l] == 0)
                {
                    cnt--;
                }
                l++;
            }

            if(cnt <= k)
            {

            int len = r - l + 1;
            maxlen = Math.max(len,maxlen);
            }
            r++;
        }

        return maxlen;
    }
}