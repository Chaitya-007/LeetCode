class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int cnt = 0;
        int maxCount = 0;

        for(int val : nums)
        {
            if(val == 1)
            {
                cnt++;
            }
            else
            {
                cnt = 0;
            }

            maxCount = Math.max(maxCount,cnt);
        }

        return maxCount;
        
    }
}