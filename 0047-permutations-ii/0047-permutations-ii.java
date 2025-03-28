class Solution {

     public void solve(int ind, int[] nums, HashSet<List<Integer>> ans, boolean[] vis, List<Integer> list)
    {
        if(ind == nums.length)
        {
            List<Integer> seq = new ArrayList<>(list);
            ans.add(seq);
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                list.add(nums[i]);
                solve(ind + 1, nums, ans, vis, list);
                vis[i] = false;
                list.remove(ind);
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();
        boolean[] vis = new boolean[n];
        List<Integer> list = new ArrayList<>();

        solve(0,nums,ans,vis,list);
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
        
    }
}