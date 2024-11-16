class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for(int i = 0; i <= (n - k); i++)
        {
            boolean flag = true;
            int first = nums[i];
            for(int j = i + 1; j < (i + k); j++)
            {
                if(nums[j] - nums[j - 1] != 1)
                {
                    flag = false;
                    break;
                }
            }

            if(flag == true)
            {
                res[i] = nums[i+k-1];
            }
            else
            {
                res[i] = -1;
            }
        }

        return res;
    }
}