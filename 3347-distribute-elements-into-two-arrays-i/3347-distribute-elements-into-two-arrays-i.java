class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        int ind = 2;
        int n = nums.length;

        while(ind < n)
        {
            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1))
            {
                list1.add(nums[ind]);
            }
            else
            {
                list2.add(nums[ind]);
            }

            ind++;
        }

        int[] ans = new int[list1.size() + list2.size()];
         ind = 0;
        for(Integer val : list1)
        {
            ans[ind] = val;
            ind++;
        }
        for(Integer val : list2)
        {
            ans[ind] = val;
            ind++;
        }

        return ans;
    }
}