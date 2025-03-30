class Solution {

    // int dp = new int[101][31];

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

        for(int i = ind; i < nums.length; i++)
        {
            if(i > ind && nums[i] == nums[i-1]) continue;

            if(nums[i] > target)
            {
                break;
            }

            if(nums[i] <= target)
            {
                list.add(nums[i]);
                solve(i + 1, target - nums[i], nums, list, ans);
                list.remove(list.size() - 1);
            }

        }
    }
     public void solvedup(int ind, int target, int[] nums, List<Integer> list, HashSet<List<Integer>> ans)
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
            solvedup(ind + 1, target - nums[ind], nums, list, ans);
            list.remove(list.size() - 1);
        }

        solvedup(ind + 1, target, nums, list, ans);
        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        // HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = candidates.length;
        solve(0, target, candidates, list, ans);
        // solvedup(0, target, candidates, list, ans);

        // List<List<Integer>> res = new ArrayList<>(ans);

        // return res;
        return ans;

    }
}