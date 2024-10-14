class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            if(set.contains(nums[i]))
            {
                list.add(nums[i]);
            }
            set.add(nums[i]);
        }

        return list;
    }
}