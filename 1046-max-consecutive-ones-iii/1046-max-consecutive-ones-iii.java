class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int l = 0;
        int r = 0;
        int n = nums.length;
        int cnt = 0;
        int maxLen = 0;

        while(r < n)
        {
            if(nums[r] == 0)
            {
                cnt++;
            }

            while(cnt > k)
            {
                if(nums[l] == 0)
                {
                    cnt--;
                }
                l++;
            }

            int len = r - l + 1;
            r++;
            maxLen = Math.max(maxLen,len);
        }

        return maxLen;
    }
}