class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val,0) + 1);
        }

        int left = 0;
        int result = 0;
        int right = nums.length;
        for(Integer val : map.values())
        {
            right -= val;
            result += (right * val * left);
            left += val;
        }

        return result;
    }
}