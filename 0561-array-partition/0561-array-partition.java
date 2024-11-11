class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i = i + 2)
        {
            sum += (nums[i]);
        }

        return sum;
    }
}