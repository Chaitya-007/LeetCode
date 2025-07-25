class Solution {
    public boolean canJump(int[] nums) {
        int maxInd = 0;
        int n = nums.length;

        // T.C -> O(N)
        // S.C -> O(1)

        for(int i = 0; i < n; i++)
        {
            if(i > maxInd) return false;

            // maxInd till which we can go is ind + arr[i]
            maxInd = Math.max(maxInd, i + nums[i]);

            // if at any moment maxInd >= n - 1 we can definitely reach end
            if(maxInd >= n-1) return true;
        }

        // dummy value
        return true;

        
    }
}