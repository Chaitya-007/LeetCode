class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        int l = 0;
        int r = 1;
        int n = nums.length;

        while(r < n)
        {
            if(nums[l] != nums[r])
            {
                l++;
                nums[l] = nums[r];
                k++;
            }

            r++;
        }

        return k;
    }
}