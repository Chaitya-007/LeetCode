class Solution {
    public long subArrayRanges(int[] nums) {

        long total = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int maxo = Integer.MIN_VALUE;
            int mino = Integer.MAX_VALUE;
            for(int j = i; j < n; j++)
            {
                mino = Math.min(nums[j],mino);
                maxo = Math.max(nums[j],maxo);

            total += (maxo - mino);
            }

            // System.out.println("mino = " + mino);
            // System.out.println("maxo = " + maxo);

        }

        return total;
        
    }
}