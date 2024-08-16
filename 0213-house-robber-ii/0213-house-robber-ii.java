class Solution {

    // int fun(int ind, int[] nums)
    // {
    //     if(ind == 0) return nums[0];
    //     if(ind < 0) return 0;
        
    //     if(dp[ind] != -1) return dp[ind];
    //     int take = nums[ind] + fun(ind-2,nums);
    //     int notTake = fun(ind-1,nums);

    //     return dp[ind] = Math.max(take,notTake);
    // }

    int compute(ArrayList<Integer> list)
    {
        int n = list.size();
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0] = list.get(0);

        for(int ind = 1; ind < n; ind++)
        {
            int take = list.get(ind);
            if(ind > 1)
            {
            take += dp[ind-2];    
            } 
            int notTake = dp[ind-1];

             dp[ind] = Math.max(take,notTake);
        }

        return dp[n-1];
    }



    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for(int i = 0; i < n; i++)
        {
            if(i != 0) list1.add(nums[i]);
            if(i != (n-1)) list2.add(nums[i]);
        }

        return Math.max(compute(list1),compute(list2));


    }
}