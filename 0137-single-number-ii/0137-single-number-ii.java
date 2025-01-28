class Solution {
    public int singleNumber(int[] nums) {

        // T.C => O(N * 32)
        // S.C => O(1)
        int ans = 0;

        for(int bitIndex = 0; bitIndex <= 31 ; bitIndex++)
        {
            int cnt = 0;
            for(int i = 0; i < nums.length; i++)
            {
                if((nums[i] & (1<<bitIndex)) != 0)
                {
                    cnt++;
                }
            }

            if(cnt%3 != 0)
            {
                ans = ans | (1<<bitIndex);
            }
        }

        return ans;
    }
}