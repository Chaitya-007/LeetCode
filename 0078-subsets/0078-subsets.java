// i = 0: 000 -> []
// i = 1: 001 -> [1]
// i = 2: 010 -> [2]
// i = 3: 011 -> [1,2]
// i = 4: 100 -> [3]
// i = 5: 101 -> [1,3]
// i = 6: 110 -> [2,3]
// i = 7: 111 -> [1,2,3]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = nums.length;
        int powSize = (1<<n);

        for(int i = 0; i < powSize; i++)
        {
            List<Integer> l = new ArrayList<Integer>();

            for(int j = 0; j  < n; j++)
            {
                if((i & (1<<j)) != 0)
                {
                    l.add(nums[j]);
                }
            }

            list.add(l);
        }

        return list;
    }
}