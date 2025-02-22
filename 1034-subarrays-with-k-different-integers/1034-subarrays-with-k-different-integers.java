class Solution {

    public int kthMost(int[] nums, int k)
    {
        // T.C -> O(2*N) * O(1)
        // S.C -> O(1)
        if(k < 0) return 0;

        int n = nums.length;

        int ans = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n) // O(N)
        {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k) // O(N)
            {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0)
                {
                    map.remove(nums[l]);
                }

                l++;
            }

            int len = r - l + 1;
            ans += len;
            r++;
        }

        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // T.C -> 2 * ( O(*2N) * O(1) )
        // S.C -> 2 * O(1)
        return kthMost(nums,k) - kthMost(nums,k-1);
        
    }
}