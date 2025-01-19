class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroes = 0;


        while(r < n)
        {
            if(nums[r] == 0)
            {
                zeroes++;
            }
   
                if(zeroes > k)
                {
                    if(nums[l] == 0)
                    {
                        zeroes--;
                    }

                    l++;
                }

            int len = r - l + 1;
            maxLen = Math.max(maxLen,len);
            r++;
        }

        return maxLen;
    }
}