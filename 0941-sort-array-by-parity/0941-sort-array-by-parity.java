class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while(l < r)
        {
            if(nums[l]%2 == 0)
            {
                l++;
            }
            else if(nums[l]%2 != 0 && nums[r]%2 == 0)
            {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;

            }
            else if(nums[l]%2 != 0 && nums[r]%2 != 0)
            {
                r--;
            }
        }

        return nums;
    }
}