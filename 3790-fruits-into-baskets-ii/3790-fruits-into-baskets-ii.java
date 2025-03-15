class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] vis = new boolean[n];
        int ans = n;

        for(int  i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(baskets[j]  >= fruits[i] && !vis[j])
                {
                    vis[j] = true;
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}