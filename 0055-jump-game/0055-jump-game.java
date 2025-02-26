class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int need = 1;

        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] >= need)
            {
                need = 1;
            }
            else
            {
                need++;
            }
        }

        return need == 1 ? true : false;
    }
}