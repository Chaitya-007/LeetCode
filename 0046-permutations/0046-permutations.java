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


    public void opt(int ind, int[] nums, List<List<Integer>> ans)
    {

        if(ind == nums.length)
        {
            List<Integer> list = new ArrayList<>();
            for(int val : nums)
            {
                list.add(val);
            }

            ans.add(new ArrayList<>(list));

            return;
        }

        
        for(int i = ind; i < nums.length; i++)
        {
            swap(ind, i, nums);
            opt(ind + 1, nums, ans);
            swap(ind, i, nums);
        }
    }

    public void swap(int ind, int i, int[] nums)
    {
        int temp = nums[ind];
        nums[ind] = nums[i];
        nums[i] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        List<Integer> list = new ArrayList<>();

        // solve(0,nums,ans,vis,list);
        opt(0,nums,ans);
        return ans;
    }
}