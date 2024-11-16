class Solution {
    public int[] sortedSquares(int[] nums) {
        int ind = 0;
        for(int val : nums)
        {
            nums[ind] = (val*val);
            ind++;
        }

        for(int i = 0; i < nums.length; i++)
        {
            int minInd = i;
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[minInd] > nums[j])
                {
                    minInd = j;
                }
            }

            int temp = nums[minInd];
            nums[minInd] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }
}