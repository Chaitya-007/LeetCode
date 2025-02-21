class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int cnt = 0;
            for(int j = i; j < n; j++)
            {
                if(nums[j] == 0)
                {
                    cnt++;
                }

                if(cnt <= k)
                {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }

        return maxlen;
    }
}