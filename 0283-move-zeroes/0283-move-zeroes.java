class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;

        int n = nums.length;

        while(r < n)
        {
            if(nums[r] == 0 && nums[l] != 0)
            {
                l = r;
            }
            else if(nums[r] != 0 && nums[l] == 0)
            {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }
    }
}