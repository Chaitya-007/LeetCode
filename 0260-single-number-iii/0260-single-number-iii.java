class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;

        for(int val : nums)
        {
            xor = xor ^ val;
        }

        int rightMost = (int)((xor & (xor - 1)) ^ (xor));

        int b1 = 0;
        int b2 = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if ((rightMost & nums[i]) != 0)
            {
                b1 = b1 ^ nums[i];
            }
            else
            {
                b2 = b2 ^ nums[i];
            }
        }

        int[] arr = {b1,b2};

        return arr;
    }
}