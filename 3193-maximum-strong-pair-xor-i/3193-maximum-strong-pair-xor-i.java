class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int result = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int x = nums[i];
            for(int j = i; j < nums.length; j++)
            {
                int y = nums[j];
                if(Math.abs(x - y) <= Math.min(x,y))
                {
                    int xor = (x^y);
                    if(result < xor)
                    {
                        result = xor;
                    }
                }
            }
        }

        return result;
    }
}