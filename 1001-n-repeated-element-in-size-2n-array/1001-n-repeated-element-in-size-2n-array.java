class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> hset = new HashSet<Integer>();

        for(int val : nums)
        {
            if(hset.contains(val)) return val;
            hset.add(val);
        }

        return -1;
    }
}