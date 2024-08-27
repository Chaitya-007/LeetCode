class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1)
        {
            return 1;
        }
        int maxInc = 1;
        for(int i = 0; i < n; i++)
        {
            int cnt = 1;
            int ele = nums[i];
            for(int j = i + 1; j < n; j++)
            {
                if(ele < nums[j])
                {
                    cnt++;
                    ele = nums[j];
                }
                else
                {
                    break;
                }
            }
            maxInc = Math.max(maxInc,cnt);
        }

        int maxDec = 1;
        for(int i = 0; i < n; i++)
        {
            int cnt = 1;
            int ele = nums[i];
            for(int j = i + 1; j < n; j++)
            {
                if(ele > nums[j])
                {
                    cnt++;
                    ele = nums[j];
                }
                else
                {
                    break;
                }
            }
            maxDec = Math.max(maxDec,cnt);
        }

    return Math.max(maxInc,maxDec);
    }

}