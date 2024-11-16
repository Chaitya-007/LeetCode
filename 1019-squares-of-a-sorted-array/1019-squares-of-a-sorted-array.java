class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int ind = r;
        while(l <= r)
        {
            if(Math.abs(nums[l]) <= Math.abs(nums[r]))
            {
                ans[ind] = (nums[r]*nums[r]);
                ind--;
                r--;
            }
            else
            {
                ans[ind] = (nums[l]*nums[l]);
                ind--;
                l++;

            }
        }

        return ans;
    }
}