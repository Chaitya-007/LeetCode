class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < 2*n; i++)
        {
            if(n <= i && i <= (2*n-1))
            {
                left[i%n] = mpp.get(nums[i%n]);
            }
            mpp.put(nums[i%n],i);
        }

        mpp.clear();

        for(int i = (3*n - 1); i >= n; i--)
        {
             if(i <= (2*n-1))
             {
                right[i%n] = mpp.get(nums[i%n]);
             }
             mpp.put(nums[i%n],i);
        }

        mpp.clear();

        for(int i = 0; i < queries.length; i++)
        {
            int qe = queries[i];
            int ind = n + qe;

            int leftdis = ind - left[ind%n];
            int rightdis = right[ind%n] - ind;

            int mindis = Math.min(leftdis,rightdis);
            if(mindis == n)
            {
                ans.add(-1);
            }
            else
            {
                ans.add(mindis);
            }
        }

        return ans;
    }
}