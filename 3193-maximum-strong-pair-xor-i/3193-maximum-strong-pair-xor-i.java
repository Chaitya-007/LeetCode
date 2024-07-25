class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] != nums[j])
                {
                if(Math.abs(nums[i] - nums[j]) <= Math.min(nums[i],nums[j]))
                {
                    int res = (nums[i] ^ nums[j]);
                    if(xor < res)
                    {
                        xor = res;
                    }
                }
                }
            }
        }

        return xor;
    }
}