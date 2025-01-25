class Solution {

    int kthMost(int[] nums,int k)
    {
        if(k < 0)
        {
            return 0;
        }
        int sum = 0;
        int l = 0;
        int r = 0;
        int maxCount = 0;
        int n = nums.length;

        while(r < n)
        {
            sum += nums[r];

            if(sum > k)
            {
                while(sum > k)
                {
                    sum -= nums[l];
                    l++;
                }
            }

            if(sum <= k)
            {
                int len = r - l + 1;
                maxCount += len;
            }

            r++;
        }

        return maxCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return kthMost(nums,goal) - kthMost(nums,goal-1);
    }
}