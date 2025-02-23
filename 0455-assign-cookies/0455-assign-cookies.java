class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // T.C -> O(N*M)
        // S.C -> O(N)
        int cnt = 0;
        int[] vis = new int[s.length];
        Arrays.fill(vis,0);
        
        for(int i = 0; i < g.length; i++)
        {
            int mino = Integer.MAX_VALUE;
            int ind = -1;
            for(int j = 0; j < s.length; j++)
            {
                if(vis[j] == 0 && s[j] >= g[i])
                {
                    if(mino >= s[j])
                    {
                        mino = s[j];
                        ind = j;
                    }
                }
            }

            if(ind != -1)
            {
                cnt++;
                vis[ind] = 1;
            }

        }

        return cnt;
    }
}