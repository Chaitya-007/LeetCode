class Solution {

    public int kthMost(int[] nums,int k)
    {
        int cnt = 0;

        int l = 0;
        int r = 0;
        int n = nums.length;
        int res = 0;
        int sum = 0;

        while(r < n)
        {
            
            sum += (nums[r]%2);

            if(sum > k)
            {
                while(sum > k)
                {
                   sum -= (nums[l]%2);
                    l++;
                }
            }

            if(sum <= k)
            {
                int len = r - l + 1;
                res += len;
            }

            r++;
        }

        return res;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        return kthMost(nums,k) - kthMost(nums,k-1);
    }
}