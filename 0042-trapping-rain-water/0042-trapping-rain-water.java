class Solution {
    public int trap(int[] height) {

        // T.C -> O(3*N)
        // S.C -> O(N)(prefix array) + O(N)(suffix array)
        int n = height.length;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];

        for(int i = 1; i < n; i++) // O(N)
        {
            prefixMax[i] = Math.max(prefixMax[i-1],height[i]);
        }

        suffixMax[n-1] = height[n-1];

        for(int i = n - 2; i >= 0; i--) // O(N)
        {
            suffixMax[i] = Math.max(height[i],suffixMax[i+1]);
        }

        int total = 0;

        for(int i = 0; i < n; i++) // O(N)
        {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];

            if(leftMax > height[i] && rightMax > height[i])
            {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
        
    }
}