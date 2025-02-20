class Solution {
    public int trap(int[] height) {

        // T.C -> O(2*N)
        // S.C -> O(N)(suffix array)
        int n = height.length;

        int[] suffixMax = new int[n];

        suffixMax[n-1] = height[n-1];

        for(int i = n - 2; i >= 0; i--) // O(N)
        {
            suffixMax[i] = Math.max(height[i],suffixMax[i+1]);
        }

        int total = 0;
        int leftMax = height[0];

        for(int i = 0; i < n; i++) // O(N)
        {
            leftMax = Math.max(height[i],leftMax);
            int rightMax = suffixMax[i];

            if(leftMax > height[i] && rightMax > height[i])
            {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
        
    }
}