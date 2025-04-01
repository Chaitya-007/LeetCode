class Solution {


    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int i = n - 1;
        while(i - 1 >= 0 && nums[i-1] > nums[i])
        {
            i--;
        }


        if(i > 0)
        {
            int breakpoint = i - 1;
            int j = n - 1;
            while(nums[breakpoint] > nums[j])
            {
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[breakpoint];
            nums[breakpoint] = temp;

            int l = i;
            int r = n - 1;
            while(l < r)
            {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
                r--;
            }
        }

        // System.out.println(Arrays.asList(nums));
    }

    public String getPermutation(int n, int k) {

        if(n == 1) 
        {
            char ch = (char)(k + '0');
            StringBuilder sb = new StringBuilder("");

            return sb.append(ch).toString();
        }

        StringBuilder sb = new StringBuilder("");
        int[] nums = new int[n];

        for(int i = 1; i <= n; i++)
        {
            nums[i - 1] = i;
        }

        for(int i = 1; i <= k - 1; i++)
        {
            nextPermutation(nums);
            // for(int val : nums)
            // {
            //     System.out.print(val + " ");
            // }
            // System.out.println();
        }

        for(int val : nums)
        {
            sb.append(val);
        }

        return sb.toString();
        
    }
}