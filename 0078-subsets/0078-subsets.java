class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        int n = nums.length;

        for(int num = 0; num < (1<<n); num++)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < n; j++)
            {
                if ( (num & (1<<j)) != 0)
                {
                    list.add(nums[j]);
                }
            }

            ll.add(list);
        }

        return ll;
    }
}