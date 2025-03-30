class Solution {

    public void fun(int ind, int target, int[] nums, List<List<Integer>> ans, List<Integer> list)
    {
        if(target == 0)
        {

            ans.add(new ArrayList<>(list));
            return;
        }

        if(ind == nums.length)
        {
            return;
        }

        for(int i = ind; i < nums.length; i++)
        {
            if(i > ind && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;

            if(nums[i] <= target)
            {
                list.add(nums[i]);
                fun(i + 1, target - nums[i], nums, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        fun(0,target,candidates,ans,list);
        return ans;
    }
}