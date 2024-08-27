class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1)
        {
            return 1;
        }

        int l = 0;
        int r = 1;
        int inc = 1;
        int dec = 1;
        int maxCount = 1;

        while(r < n)
        {
            if(nums[l] < nums[r])
            {
                dec = 1;
                inc++;
                l = r;
                r++;
                maxCount = Math.max(inc,maxCount);
            }
            else if(nums[l] > nums[r])
            {
                inc = 1;
                dec++;
                l = r;
                r++;
                maxCount = Math.max(dec,maxCount);
            }
            else
            {
                inc = 1;
                dec = 1;
                r++;
            }
        }

        return maxCount;
    }
}