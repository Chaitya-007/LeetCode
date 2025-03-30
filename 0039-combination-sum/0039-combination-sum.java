class Solution {

    public void solve(int ind, int target, int[] nums, List<Integer> list, List<List<Integer>> ans)
    {
        if(target == 0)
        {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }

        if(ind == nums.length)
        {
            return;
        }

        if(nums[ind] <= target)
        {
            list.add(nums[ind]);
            solve(ind, target - nums[ind], nums, list, ans);
            list.remove(list.size() - 1);
        }

        solve(ind + 1, target, nums, list, ans);
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = candidates.length;
        solve(0, target, candidates, list, ans);
        return ans;
    }
}