class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> h1 = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            h1.add(nums[i]);
        Set<Integer> h2 = new HashSet<Integer>();

            for(int j = i + 1; j < nums.length; j++)
            {
                h2.add(nums[j]);
            }

            nums[i] = (h1.size() - h2.size());
        }

        return nums;
    }
}