class Solution {
    public int[] singleNumber(int[] nums) {

        // T.C => O(2N)
        // S.C => O(1)

        // make this as long because 
        // if xor => -2^31
        // and xor -1 => -2^31 - 1 will overflow
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