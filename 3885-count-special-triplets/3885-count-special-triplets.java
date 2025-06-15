class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        HashMap<Integer, Integer> nextMap = new HashMap<>();
        
        // Initialize nextMap with all elements from index 1 to n-1
        for (int i = 1; i < n; i++) {
            nextMap.put(nums[i], nextMap.getOrDefault(nums[i], 0) + 1);
        }
        
        long count = 0;
        
        // Iterate j from 1 to n-2 (middle element)
        for (int j = 1; j <= n - 2; j++) {
            // Move nums[j-1] from "future" to "past"
            prevMap.put(nums[j - 1], prevMap.getOrDefault(nums[j - 1], 0) + 1);
            
            // Remove nums[j] from nextMap (it's now the current middle element)
            nextMap.put(nums[j], nextMap.get(nums[j]) - 1);
            if (nextMap.get(nums[j]) == 0) {
                nextMap.remove(nums[j]);
            }
            
            // Look for special triplets: nums[i] = nums[j]*2 and nums[k] = nums[j]*2
            int target = nums[j] * 2;
            
            if (prevMap.containsKey(target) && nextMap.containsKey(target)) {
                long leftCount = prevMap.get(target);
                long rightCount = nextMap.get(target);
                count = (count + (leftCount * rightCount) % MOD) % MOD;
            }
        }
        
        return (int) count;
    }
}