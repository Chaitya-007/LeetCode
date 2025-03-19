class Solution {

    public boolean isSubsetSum(List<Integer> arr , int sum) {
        // code here
        int n = arr.size();
        // return fun(n-1,arr,sum);
        boolean[][] dp = new boolean[n][sum+1];
        
        // return funMemo(n-1,arr,sum,dp);
        
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = true;
        }
        
        for(int target = 1; target <= sum; target++)
        {
            dp[0][target] = (arr.get(0) == target);
        }
        
        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 1; target <= sum; target++)
            {
            
                boolean notpick = dp[ind - 1][target];
                boolean pick = false;
                
                if(arr.get(ind) <= target)
                {
                    pick = dp[ind - 1][target - arr.get(ind)];
                }
                
                 dp[ind][target] = pick | notpick;          
                
            }
        }
        
        
        
        return dp[n-1][sum];
        
    }

    public boolean check(int[] nums, int[][] queries, int m)
    {
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            int target = nums[i];

            if(target == 0)
            {
                continue;
            }
            
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < m; j++)
            {
                int l = queries[j][0];
                int r = queries[j][1];
                int qval = queries[j][2];
                if(l <= i && i <= r)
                {
                    list.add(qval);
                }
            }

            if(list.size() == 0) return false;
            if(!isSubsetSum(list,target)) return false;
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int l = 0;
        int r = m;
        int ans = -1;

        while( l <= r)
        {
            int mid = (l + r) >> 1;

            if(check(nums,queries,mid))
            {
                r = mid - 1;
                ans = mid;
            }
            else
            {
                l = mid + 1;
            }
        }

        return ans;
    }
}