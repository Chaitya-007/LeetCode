class Solution {
    public int trap(int[] height) {

        // T.C -> O(N)
        // S.C -> O(1)
        int n = height.length;

        int total = 0;
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = n - 1;

        while(l < r)
        {
            if(height[l] <= height[r])
            {
                if(leftMax > height[l])
                {
                    total += (leftMax - height[l]);
                }
                else
                {
                    leftMax = height[l];
                }

                l++;
            }
            else
            {
                if(rightMax > height[r])
                {
                    total += (rightMax - height[r]);
                }
                else
                {
                    rightMax = height[r];
                }

                r--;
            }
        }


        return total;
        
    }
}