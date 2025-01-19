class Solution {

    public int kthMost(int[] nums,int k)
    {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        while(r < n)
        {
            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);

            if(map.size() > k)
            {
                while(map.size() > k)
                {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if(map.get(nums[l]) == 0)
                    {
                        map.remove(nums[l]);
                    }
                    l++;
                }
            }
            
            int len = r - l + 1;
            sum += len;
            r++;
        }

        return sum;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = kthMost(nums,k) - kthMost(nums,k-1);
        return ans;
    }
}