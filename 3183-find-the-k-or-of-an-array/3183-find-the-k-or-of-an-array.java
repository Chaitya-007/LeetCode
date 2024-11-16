class Solution {
    public int findKOr(int[] nums, int k) {
        int result = 0;
        
        for(int i = 0; i < 32; i++)
        {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if((nums[j] & (1 << i)) != 0)
                {
                    cnt++;
                }

                if(cnt >= k)
                {
                    result += (1 << i);
                    break;
                }
            }
        }

        return result;
    }
}