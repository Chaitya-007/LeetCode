class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] temp = new int[2*n];
        int ind = 0;

        for(int i = 0; i < n; i++)
        {
            
                temp[ind] = nums[i];
                ind++;
                temp[ind] = nums[n + i];
                ind++;
            
        }

        return temp;
    }
}