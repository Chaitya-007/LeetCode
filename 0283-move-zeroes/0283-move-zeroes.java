class Solution {
    public void moveZeroes(int[] nums) {

     int r = 0;
     int n = nums.length;

     while(r<n)
     {
        if(nums[r] != 0)
        {
            int j = r;
            while(j > 0 && nums[j-1] == 0)
            {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
        r++;
     }

    }
}