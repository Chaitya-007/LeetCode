class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int one = 0;
        int maxnum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                one++;
            }
            else 
            {
                one = 0;
            }

            maxnum = Math.max(maxnum,one);
        }

        return maxnum;
    }
}