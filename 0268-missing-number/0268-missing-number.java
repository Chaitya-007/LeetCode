class Solution {
    public int missingNumber(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i : nums)
        {
            hs.add(i);
        }

        for(int i = 0; i <= nums.length; i++)
        {
            if(!hs.contains(i))
            {
                return i;
            }
        }

        return -1;
    }
}