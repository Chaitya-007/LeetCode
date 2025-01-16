class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer> ();
        hmap.put(0,1);
        int sum = 0;
        int cnt = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            sum += nums[i];

            int rem = sum - k;

            if(hmap.containsKey(rem))
            {
                cnt += hmap.get(rem);
            }

            hmap.put(sum,hmap.getOrDefault(sum,0) + 1);
        }

        return cnt;
    }
}