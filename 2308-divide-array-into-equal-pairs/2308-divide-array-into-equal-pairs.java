class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> hset = new HashSet<Integer>();

        for(int val : nums)
        {
            if(hset.contains(val))
            {
                hset.remove(val);
            }
            else
            {
                hset.add(val);
            }
        }

        if(hset.size() == 0)
        {
            return true;
        }

        return false;
    }
}