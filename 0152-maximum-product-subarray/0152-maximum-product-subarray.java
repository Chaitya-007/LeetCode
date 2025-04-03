class Solution {
    public int maxProduct(int[] nums) {
     int maxp = Integer.MIN_VALUE;  
     int pre = 1;
     int suff = 1; 
     int n = nums.length;

        for(int i = 0; i < nums.length; i++)
        {

            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre *= nums[i];
            suff *= nums[n - 1 - i];


            maxp = Math.max(maxp, Math.max(pre,suff));

        }

        return maxp;

    }
}