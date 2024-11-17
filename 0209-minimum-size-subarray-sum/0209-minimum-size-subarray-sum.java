class Solution {
    public int minSubArrayLen(int k, int[] nums) {


        int l = 0;
        int r = 0;
        int sum = 0;
        int n = nums.length;
        int minlen = n;
        boolean flag = true;

        while(r < n)
        {
            sum += nums[r];
           

             if(sum >= k)
            {
                while(sum >= k)
                {
                    flag = false;
                    minlen = Math.min(minlen, r - l + 1);
                    sum -= nums[l];
                    l++;
                }
            }

           r++;
        }

        if(flag) return 0;

        return minlen;
    }
}