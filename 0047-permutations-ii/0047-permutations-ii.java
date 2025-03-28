class Solution {

     public void solve(int ind, int[] nums, List<List<Integer>> ans, boolean[] vis, List<Integer> list)
    {
        if(ind == nums.length)
        {
            List<Integer> seq = new ArrayList<>(list);
            ans.add(seq);
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {

            if(i > 0 && nums[i] == nums[i-1] && !vis[i-1])
            {
                continue;
            }

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

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        List<Integer> list = new ArrayList<>();

        solve(0,nums,ans,vis,list);
        
        return ans;
        
    }
}