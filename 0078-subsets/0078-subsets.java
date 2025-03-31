class Solution {

    public void solve(int ind, List<List<Integer>> ans, List<Integer> list, int[] nums)
    {
        if(ind == nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[ind]);
        solve(ind+1,ans,list,nums);
        list.remove(list.size() - 1);
        solve(ind + 1, ans, list, nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, ans, list, nums);
        return ans;

    }
}