class Solution {

    public void dfs(int node,boolean[] vis,List<List<Integer>> adj)
    {
        vis[node] = true;

        for(Integer val : adj.get(node))
        {
            if(!vis[val])
            {
                dfs(val,vis,adj);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= vertices; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        int n = isConnected.length;
        int m = isConnected[0].length;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                // if(i != j)
                // {
                    if(isConnected[i][j] == 1)
                    {
                        int u = i+1;
                        int v = j+1;
                        adj.get(u).add(v);
                        adj.get(v).add(u);
                    }
                // }
            }
        }

        boolean[] vis = new boolean[vertices+1];
        int cnt = 0;

        for(int i = 1; i <= vertices; i++)
        {
            if(!vis[i])
            {
                cnt++;
                dfs(i,vis,adj);
            }
        }

        return cnt;
        
    }
}