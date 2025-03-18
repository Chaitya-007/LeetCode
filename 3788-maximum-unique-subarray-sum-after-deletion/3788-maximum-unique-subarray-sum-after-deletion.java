class Solution {
    public int maxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] > 0 && !set.contains(nums[i]))
            {
                sum += nums[i];
                set.add(nums[i]);
            }
            else
            {
                maxSum = Math.max(nums[i],maxSum);
            }
        }

        if(set.isEmpty()) return maxSum;

        return sum;
    }
}