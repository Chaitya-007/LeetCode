class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for(int val : nums)
        {
            mp.put(val, mp.getOrDefault(val,0) + 1);
            if(mp.get(val) == (nums.length/2))
            {
                return val;
            }
        }

        return -1;

    }
}