class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(nums[0] >= nums[1]) return false;
        if(nums[n - 2] >= nums[n - 1]) return false;

        int i = 1;
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;

        while(i < n)
            {
                if(nums[i-1] < nums[i])
                {
                    f1 = true;
                    i++;
                }
                else
                {
                    break;
                }
            }

        if(!f1) return false;

        while(i < n)
            {
                if(nums[i-1] > nums[i])
                {
                    f2 = true;
                    i++;
                }
                else
                {
                    break;
                }
                
            }
        if(!f2) return false;
        
        while(i < n)
            {
                if(nums[i-1] < nums[i])
                {
                    f3 = true;
                    i++;
                }
                else
                {
                    break;
                }
                
            }
        if(!f3) return false;

        if(i != n) return false;

        return true;

        
    }
}