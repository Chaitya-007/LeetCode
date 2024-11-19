class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long n = nums.length;
        long maxSum = 0;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(r < k)
        {
            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);
            sum += nums[r];
            r++;
        }

        if(map.size() == k)
        {
            maxSum = Math.max(maxSum,sum);
        }

        while(r < n)
        {
            map.put(nums[l], map.get(nums[l]) - 1);
            if(map.get(nums[l]) == 0)
            {
                map.remove(nums[l]);
            }
            sum -= nums[l];
            l++;
            sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);
            r++;
            if(map.size() == k)
            {
                maxSum = Math.max(maxSum,sum);
            }
        }

        return maxSum;
    }
}