class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int ind = 0;
        for(Integer val : nums)
        {
            int bit = 0;
            while((val & (1 << bit)) !=  0)
            {bit++;}
            ans[ind] = val > 2 ? (val ^ (1 << (bit - 1)) ) : -1;
            ind++;
        }

        return ans;
    }
}