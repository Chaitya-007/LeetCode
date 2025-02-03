class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < (1<<n); i++)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < n; j++)
            {
                if ( (i & (1<<j)) != 0)
                {
                    list.add(nums[j]);
                }
            }

            ll.add(list);
        }

        return ll;
    }
}