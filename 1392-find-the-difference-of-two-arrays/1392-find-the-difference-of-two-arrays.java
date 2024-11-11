class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> hset1 = new HashSet<Integer>();
        Set<Integer> hset2 = new HashSet<Integer>();
        Set<Integer> hset3 = new HashSet<Integer>();
        Set<Integer> hset4 = new HashSet<Integer>();

        for(int val : nums1)
        {
            hset1.add(val);
        }

        for(int val : nums2)
        {
            hset2.add(val);
        }

        for(int val : nums1)
        {
            if(!hset2.contains(val))
            {
                hset3.add(val);
            }
        }

        for(int val : nums2)
        {
            if(!hset1.contains(val))
            {
                hset4.add(val);
            }
        }

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(Integer num : hset3)
        {
            list1.add(num);
        }

        for(Integer num : hset4)
        {
            list2.add(num);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        res.add(list1);
        res.add(list2);

        return res;
        

    }
}