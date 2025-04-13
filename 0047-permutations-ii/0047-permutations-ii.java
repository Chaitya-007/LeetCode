class Solution {

     public void solve(int ind, int[] nums, List<List<Integer>> ans, boolean[] vis, List<Integer> list)
    {
        if(ind == nums.length)
        {
            List<Integer> seq = new ArrayList<>(list);
            ans.add(seq);
            return;
        }

        for(int i = ind; i < nums.length; i++)
        {

            if(i > ind && nums[i] == nums[i-1])
            {
                continue;
            }

            if(!vis[i])
            {
                vis[i] = true;
                list.add(nums[i]);
                solve(i + 1, nums, ans, vis, list);
                vis[i] = false;
                list.remove(ind);
            }
        }
    }

     public void solve(int ind, int[] nums, List<List<Integer>> ans, HashMap<Integer, Integer> map, List<Integer> list)
    {
        if(ind == nums.length)
        {
            List<Integer> seq = new ArrayList<>(list);
            ans.add(seq);
            return;
        }

       for(Map.Entry<Integer, Integer> e : map.entrySet())
       {
            if(e.getValue() > 0)
            {
                map.put(e.getKey(), map.get(e.getKey()) - 1);
                list.add(e.getKey());
                solve(ind + 1, nums, ans, map, list);
                map.put(e.getKey(), map.get(e.getKey()) + 1);
                list.remove(ind);
            }
       }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;

        // Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        // boolean[] vis = new boolean[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val,0) + 1);
        }


        List<Integer> list = new ArrayList<>();

        // solve(0,nums,ans,vis,list);
        solve(0,nums,ans,map,list);
        
        return ans;
        
    }
}