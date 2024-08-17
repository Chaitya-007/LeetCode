class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int[] visited = new int[n];
        Arrays.fill(visited,0);
        int cnt = 0;

        for(int i = 0; i < s.length; i++)
        {
            int maxo = Integer.MIN_VALUE;
            int ind = -1;

            for(int j = 0; j < g.length; j++)
            {
                if(visited[j] != 1 && s[i] >= g[j])
                {
                    if(maxo < g[j])
                    {
                        maxo = g[j];
                        ind = j;
                        
                    }
                }
            }

            if(ind != -1)
            {
            visited[ind] = 1;
            cnt++;
            }
        }

        return cnt;
    }
}