class Solution {
    public boolean isArraySpecial(int[] nums) {
        int l = 0;
        int r = 1;
        int n = nums.length;
        while(r < n)
        {
            if( (nums[l]%2 == 0 && nums[r]%2 != 0) || (nums[l]%2 != 0 && nums[r]%2 == 0 ) )
            {
               l++;
               r++;
            }
            else 
            {
                return false;
            }
        }

        return true;
    }
}