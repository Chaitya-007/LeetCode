class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0)
        {
            int ind = 0;
            int mino = nums[0];

            for(int i = 0; i < nums.length; i++)
            {
                if(mino > nums[i])
                {
                    mino = nums[i];
                    ind = i;
                }
            }

            nums[ind] = (mino*multiplier);
            k--;
        }   

        return nums;
    }
}