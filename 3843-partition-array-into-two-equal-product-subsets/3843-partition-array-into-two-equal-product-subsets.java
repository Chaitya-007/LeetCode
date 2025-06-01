class Solution {

    public boolean fun(long total, long curr, int ind, int[] arr, long target)
    {
        if(ind == arr.length)
        {
            if(curr == target && total == (target * curr) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        boolean notPick = fun(total,curr,ind + 1,arr,target);
        boolean pick = false;

        curr *= (long)arr[ind];

        if(curr <= target)
        {
        pick = fun(total,curr,ind + 1, arr, target);
            
        }

        return pick | notPick;
    }

    
    public boolean checkEqualPartitions(int[] nums, long target) {

        long total = 1;
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
            {
                total *= (long)(nums[i]);        
            }

        return fun(total,1,0,nums,target);
        
    }
}