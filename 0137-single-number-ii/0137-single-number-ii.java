class Solution {
    public int singleNumber(int[] nums) {
        // T.C => O(n*logn) + O(n/3)
        // S.C => O(1)

        Arrays.sort(nums);

        int n = nums.length;

        // Start with index 1
        for(int i = 1; i < n; i = i + 3)
        {
            if(nums[i-1] != nums[i])
            {
                return nums[i-1];
            }
        }

        return nums[n-1];
    }
}