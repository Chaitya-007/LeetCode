class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;

        for(int val : nums)
        {
            xor ^= val;
        }

        int rightMost = (int)( (xor & (xor - 1)) ^ xor);

        int b1 = 0;
        int b2 = 0;

        for(int val : nums)
        {
            if( (val & rightMost) != 0)
            {
                b1 = b1 ^ val;
            }
            else
            {
                b2 = b2 ^ val;
            }
        }

        int[] arr = {b1,b2};

        return arr;
    }
}