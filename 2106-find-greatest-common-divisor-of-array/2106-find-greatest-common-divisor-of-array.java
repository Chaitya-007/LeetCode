class Solution {
    public int findGCD(int[] nums) {
        int maxo = nums[0];
        int mino = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            if(maxo < nums[i])
            {
                maxo = nums[i];
            }

            if(mino > nums[i])
            {
                mino = nums[i];
            }
        }

        while(maxo > 0 && mino > 0)
        {
            if(maxo > mino)
            {
                maxo = maxo%mino;
            }
            else
            {
                mino = mino%maxo;
            }
        }

        if(mino == 0)
        {
            return maxo;
        }

        return mino;
    }
}