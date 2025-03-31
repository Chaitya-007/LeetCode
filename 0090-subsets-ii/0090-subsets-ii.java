class Solution {

    public void fun(int ind, int[] nums, List<Integer> list, List<List<Integer>> ans)
    {

        for(int i = ind; i < nums.length; i++)
        {
            if(i > ind && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            fun(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        ans.add(new ArrayList<>(list));

        fun(0,nums,list,ans);

        return ans;
        
    }
}