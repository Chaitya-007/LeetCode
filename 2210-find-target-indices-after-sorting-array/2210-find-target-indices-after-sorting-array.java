class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < (n - 1); i++)
        {
           
            int minIndex = i;
            for(int j = i + 1; j < n; j++)
            {
                if(nums[minIndex] > nums[j])
                {
                    minIndex = j ;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                list.add(i);
            }
        }

        return list;
    }
}