class Solution {
    public int minimumOperations(int[] nums) {
        int sum = 0;
        for(int val : nums)
        {
            sum += val;
        }

        int opr = 0;

        while(sum != 0)
        {
            int mino = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++)
            {
                if( (nums[i] > 0) && (mino > nums[i]) )
                {
                    mino = nums[i];
                }
            }

            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] > 0)
                {
                    nums[i] = nums[i] - mino;
                    sum -= (mino);
                }
            }

            opr++;

        }

        return opr;
    }
}