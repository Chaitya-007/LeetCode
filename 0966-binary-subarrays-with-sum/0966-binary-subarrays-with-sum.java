class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // T.C -> O(N) * O(log N)
        // S.C -> O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int cnt = 0;
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            sum += nums[i];

            int rem = sum - goal;

            if(map.containsKey(rem))
            {
                cnt += map.get(rem);
            }

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return cnt;
    }
}