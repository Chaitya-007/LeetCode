class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> hset1 = new HashSet<Integer>();
        Set<Integer> hset2 = new HashSet<Integer>();
       
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int val : nums1)
        {
            hset1.add(val);
        }

        for(int val : nums2)
        {
            hset2.add(val);
        }

        for(int val : hset1)
        {
            if(!hset2.contains(val))
            {
                list1.add(val);
            }
        }

        for(int val : hset2)
        {
            if(!hset1.contains(val))
            {
                list2.add(val);
            }
        }


        List<List<Integer>> res = new ArrayList<List<Integer>>();

        res.add(list1);
        res.add(list2);

        return res;
        

    }
}