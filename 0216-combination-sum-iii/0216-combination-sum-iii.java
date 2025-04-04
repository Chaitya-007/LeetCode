class Solution {

    public void fun(int ind, int prev, List<Integer> list, List<List<Integer>> ans, int k, int n, int sum)
    {
        if(ind == k)
        {
            if(sum == n)
            {
                ans.add(new ArrayList<>(list));
            }

            return;
        }

        for(int i = prev; i <= 9; i++)
        {
            if(sum + i > n) break;
            sum = sum + i;
            list.add(i);
            fun(ind + 1, i + 1, list, ans, k, n, sum);
            sum = sum - i;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        fun(0,1,new ArrayList<>(), ans, k, n, 0);
        return ans;
        
    }
}