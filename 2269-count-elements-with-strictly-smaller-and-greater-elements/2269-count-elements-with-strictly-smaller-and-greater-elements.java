class Solution {
    public int countElements(int[] nums) {
        int mino = nums[0];
        int maxo = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            if(mino > nums[i])
            {
                mino = nums[i];
            }

            if(maxo < nums[i])
            {
                maxo = nums[i];
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++)
        {
            if(mino < nums[i] && nums[i] < maxo)
            {
                cnt++;
            }
        }

        return cnt;
    }
}