class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < (1 << n); i++)
        {
            List<Integer> list = new ArrayList<>();

            for(int ind = 0; ind < n; ind++)
            {
                if ( (i & (1 << ind) ) != 0)
                {
                    list.add(nums[ind]);
                }
            }

            ans.add(list);
        }

        return ans;
        
    }
}