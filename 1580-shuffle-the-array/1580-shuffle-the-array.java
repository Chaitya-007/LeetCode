class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int ind = 0;

        for(int i = 0; i < n; i++)
        {
            ans[ind] = nums[i];
            ind++;
            ans[ind] = nums[i+n];
            ind++;
        }

        return ans;
    }
}