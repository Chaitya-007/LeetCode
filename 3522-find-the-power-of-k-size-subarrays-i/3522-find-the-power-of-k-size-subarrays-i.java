class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        
        if(n == 1) 
        {
            int[] ans = {nums[0]};
            return ans;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i <= (n - k); i++)
        {
            int r = i + 1;
            int cnt = 1;
            boolean flag = true;;

            while(cnt <= (k-1))
            {
                if(nums[r] - nums[r-1] != 1)
                {
                    flag = false;
                    break;
                }
                else
                {
                    r++;
                }
                cnt++;
                
            }
            
            if(flag)
            {
                list.add(nums[r-1]);
            }
            else
            {
                list.add(-1);
            }
            
            
        }
        
        
        
        int[] ans = new int[list.size()];
        int i = 0;
        
        for(Integer num: list)
        {
            ans[i] = num;
            i++;
        }
        
        return ans;
    }
}